package com.syphan.financial.domain.command

import java.util.UUID

data class RemoveNotificationCommand(
    val notificationIds: List<UUID>,
)
