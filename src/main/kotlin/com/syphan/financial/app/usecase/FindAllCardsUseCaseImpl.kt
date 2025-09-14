package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toCardEntity
import com.syphan.financial.app.provider.mysql.repository.CardRepository
import com.syphan.financial.domain.entity.CardEntity
import com.syphan.financial.domain.usecase.FindAllCardsUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class FindAllCardsUseCaseImpl(
    private val cardRepository: CardRepository,
) : FindAllCardsUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(): List<CardEntity> {
        logger.info("Fetching all cards from the database")
        return cardRepository.findAll().map { it.toCardEntity() }.also {
            logger.info("Fetched ${it.size} cards")
        }
    }
}
