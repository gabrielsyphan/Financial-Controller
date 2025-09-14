package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toNotificationEntity
import com.syphan.financial.app.provider.mysql.model.toNotificationModel
import com.syphan.financial.app.provider.mysql.repository.NotificationRepository
import com.syphan.financial.domain.command.CreateNotificationCommand
import com.syphan.financial.domain.service.NotificationEmitterService
import com.syphan.financial.domain.usecase.CreateNotificationUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Component
class CreateNotificationUseCaseImpl(
    private val emitNotificationUseCase: NotificationEmitterService<SseEmitter>,
    private val notificaationRepository: NotificationRepository,
) : CreateNotificationUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(command: CreateNotificationCommand) {
        logger.info("Creating notification: ${command.title}")
        notificaationRepository
            .save(command.toNotificationModel())
            .also {
                logger.info("Notification saved with id ${it.id}")
                emitNotificationUseCase.execute(it.toNotificationEntity())
                logger.info("Notification emitted to subscribers")
            }
    }
}
