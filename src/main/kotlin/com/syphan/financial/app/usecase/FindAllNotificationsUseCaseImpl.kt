package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toNotificationEntity
import com.syphan.financial.app.provider.mysql.repository.NotificationRepository
import com.syphan.financial.domain.entity.NotificationEntity
import com.syphan.financial.domain.usecase.FindAllNotificationsUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class FindAllNotificationsUseCaseImpl(
    private val notificationRepository: NotificationRepository,
) : FindAllNotificationsUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(): List<NotificationEntity> {
        logger.info("Executing FindAllNotificationsUseCase")
        return notificationRepository
            .findAll()
            .map { it.toNotificationEntity() }
            .also {
                logger.info("Found ${it.size} notifications")
            }
    }
}
