package com.syphan.financial.app.provider.mysql.model

import com.syphan.financial.domain.command.CreateNotificationCommand
import com.syphan.financial.domain.entity.NotificationEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "notifications")
data class NotificationModel(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(name = "title", nullable = false, length = 20)
    val title: String,
    @Column(name = "message", nullable = false, length = 255)
    val message: String,
    @Column(name = "link", nullable = true, length = 255)
    val link: String? = null,
    @Column(name = "is_read", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE", length = 1)
    val isRead: Boolean = false,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDateTime? = null,
)

fun CreateNotificationCommand.toNotificationModel() =
    NotificationModel(
        title = this.title,
        message = this.message,
        link = this.link,
    )

fun NotificationModel.toNotificationEntity() =
    NotificationEntity(
        id = this.id,
        title = this.title,
        message = this.message,
        isRead = this.isRead,
        link = this.link,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
