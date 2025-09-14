package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.command.RemoveNotificationCommand

interface RemoveNotificationUseCase {
    fun execute(command: RemoveNotificationCommand)
}
