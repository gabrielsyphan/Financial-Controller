package com.syphan.financial.app.controller.app.notification

import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.command.CreateNotificationCommand
import com.syphan.financial.domain.usecase.CreateNotificationUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.NOTIFICATIONS.SEND_TEST)
class GetEmitManualNotificationController(
    private val createNotificationUseCase: CreateNotificationUseCase,
) {
    @GetMapping("/{title}/{message}")
    fun test(
        @PathVariable title: String,
        @PathVariable message: String,
    ) = createNotificationUseCase.execute(
        CreateNotificationCommand(
            title = title,
            message = message,
        ),
    )
}
