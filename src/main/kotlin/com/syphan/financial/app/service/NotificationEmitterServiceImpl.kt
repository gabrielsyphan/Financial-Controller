package com.syphan.financial.app.service

import com.syphan.financial.domain.entity.NotificationEntity
import com.syphan.financial.domain.service.NotificationEmitterService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.CopyOnWriteArraySet

@Service
class NotificationEmitterServiceImpl : NotificationEmitterService<SseEmitter> {
    private val logger = LoggerFactory.getLogger(this::class.java)
    private val emitters: MutableSet<SseEmitter> = CopyOnWriteArraySet()
    private val emitterTimeout: Long = Long.MAX_VALUE

    override fun subscribe(): SseEmitter {
        logger.info("New client subscribed to notifications")

        val emitter = SseEmitter(emitterTimeout)
        emitters.add(emitter)

        emitter.onCompletion { removeEmitter(emitter) }
        emitter.onTimeout { removeEmitter(emitter) }
        emitter.onError { ex ->
            logger.warn("SSE emitter error: ${ex?.message}")
            removeEmitter(emitter)
        }

        return emitter
    }

    override fun execute(notification: NotificationEntity) {
        val deadEmitters = mutableListOf<SseEmitter>()
        emitters.forEach { emitter ->
            try {
                emitter.send(SseEmitter.event().name("notification").data(notification))
            } catch (e: Exception) {
                logger.error("Failed to send notification: ${e.message}")
                deadEmitters.add(emitter)
            }
        }
        emitters.removeAll(deadEmitters.toSet())
    }

    override fun removeEmitter(emitter: SseEmitter) {
        emitters.remove(emitter)
    }
}
