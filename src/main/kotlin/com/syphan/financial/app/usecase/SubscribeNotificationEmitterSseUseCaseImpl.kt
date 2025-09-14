package com.syphan.financial.app.usecase

import com.syphan.financial.domain.service.NotificationEmitterService
import com.syphan.financial.domain.usecase.SubscribeNotificationEmitterSseUseCase
import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Component
class SubscribeNotificationEmitterSseUseCaseImpl(
    private val notificationEmitterService: NotificationEmitterService<SseEmitter>,
) : SubscribeNotificationEmitterSseUseCase<SseEmitter> {
    override fun execute(): SseEmitter = notificationEmitterService.subscribe()
}
