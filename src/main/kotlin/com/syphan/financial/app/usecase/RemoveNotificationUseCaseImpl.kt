package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.repository.NotificationRepository
import com.syphan.financial.domain.command.RemoveNotificationCommand
import com.syphan.financial.domain.usecase.RemoveNotificationUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RemoveNotificationUseCaseImpl(
    private val notificationRepository: NotificationRepository,
) : RemoveNotificationUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(command: RemoveNotificationCommand) {
        logger.info("Removing notification with ids: ${command.notificationIds}")
        if (command.notificationIds.isEmpty()) {
            notificationRepository.deleteAll().also {
                logger.info("All notifications have been removed")
            }
        } else {
            notificationRepository.deleteByIdIn(command.notificationIds).also {
                logger.info("All notifications with ids: ${command.notificationIds} have been removed")
            }
        }
    }
}
