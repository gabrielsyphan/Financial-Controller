package com.syphan.financial.domain.entity

import java.time.LocalDateTime
import java.util.UUID

data class NotificationEntity(
    val id: UUID,
    val title: String,
    val message: String,
    val isRead: Boolean,
    val link: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
)
