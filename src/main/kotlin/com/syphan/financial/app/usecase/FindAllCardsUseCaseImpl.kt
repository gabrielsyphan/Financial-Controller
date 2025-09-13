package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toCardEntity
import com.syphan.financial.app.provider.mysql.repository.CardRepository
import com.syphan.financial.domain.entity.CardEntity
import com.syphan.financial.domain.usecase.FindAllCardsUseCase
import org.springframework.stereotype.Service

@Service
class FindAllCardsUseCaseImpl(
    private val cardRepository: CardRepository,
) : FindAllCardsUseCase {
    override fun execute(): List<CardEntity> = cardRepository.findAll().map { it.toCardEntity() }
}
