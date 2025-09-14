package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.command.CreateNotificationCommand

interface CreateNotificationUseCase {
    fun execute(command: CreateNotificationCommand)
}
