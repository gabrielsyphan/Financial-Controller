package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.entity.CardEntity

interface FindAllCardsUseCase {
    fun execute(): List<CardEntity>
}
