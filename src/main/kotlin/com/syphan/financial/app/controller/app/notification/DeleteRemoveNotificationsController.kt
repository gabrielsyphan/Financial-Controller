package com.syphan.financial.app.controller.app.notification

import com.syphan.financial.app.controller.app.notification.request.RemoveNotificationRequest
import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.command.RemoveNotificationCommand
import com.syphan.financial.domain.usecase.RemoveNotificationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.NOTIFICATIONS.REMOVE)
class DeleteRemoveNotificationsController(
    private val removeNotificationUseCase: RemoveNotificationUseCase,
) {
    @DeleteMapping
    fun execute(
        @RequestBody request: RemoveNotificationRequest,
    ): ResponseEntity<Void> {
        removeNotificationUseCase.execute(
            RemoveNotificationCommand(
                notificationIds = request.notificationIds,
            ),
        )
        return ResponseEntity.noContent().build()
    }
}
