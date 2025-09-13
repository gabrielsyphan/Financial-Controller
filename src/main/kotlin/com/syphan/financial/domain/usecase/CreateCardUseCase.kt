package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.command.CreateCardCommand
import com.syphan.financial.domain.entity.CardEntity

interface CreateCardUseCase {
    fun execute(command: CreateCardCommand): CardEntity
}
