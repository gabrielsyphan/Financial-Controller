package com.syphan.financial.app.controller.app.notification

import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.entity.NotificationEntity
import com.syphan.financial.domain.usecase.FindAllNotificationsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.NOTIFICATIONS.ALL)
class GetFindAllNotificationsController(
    private val findAllNotificationsUseCase: FindAllNotificationsUseCase,
) {
    @GetMapping
    fun execute(): ResponseEntity<List<NotificationEntity>> =
        ResponseEntity.ok(
            findAllNotificationsUseCase.execute(),
        )
}
