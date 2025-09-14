package com.syphan.financial.app.controller.app.notification.request

import java.util.UUID

data class RemoveNotificationRequest(
    val notificationIds: List<UUID>,
)
