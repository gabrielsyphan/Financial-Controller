package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.entity.NotificationEntity

interface FindAllNotificationsUseCase {
    fun execute(): List<NotificationEntity>
}
