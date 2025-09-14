package com.syphan.financial.app.controller.app.notification

import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.usecase.SubscribeNotificationEmitterSseUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
@RequestMapping(ApiPathConstants.NOTIFICATIONS.SUBSCRIBE)
class GetSubscribeNotificationsSseController(
    private val subscribeNotificationEmitterSseUseCase: SubscribeNotificationEmitterSseUseCase<SseEmitter>,
) {
    @GetMapping
    fun execute() = subscribeNotificationEmitterSseUseCase.execute()
}
