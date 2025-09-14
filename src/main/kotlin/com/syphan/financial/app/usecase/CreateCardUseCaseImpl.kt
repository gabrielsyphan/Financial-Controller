package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toCardEntity
import com.syphan.financial.app.provider.mysql.model.toCardModel
import com.syphan.financial.app.provider.mysql.repository.CardRepository
import com.syphan.financial.domain.command.CreateCardCommand
import com.syphan.financial.domain.entity.CardEntity
import com.syphan.financial.domain.usecase.CreateCardUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CreateCardUseCaseImpl(
    private val cardRepository: CardRepository,
) : CreateCardUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(command: CreateCardCommand): CardEntity {
        logger.info("Creating card with command: $command")
        return cardRepository.save(command.toCardModel()).toCardEntity().also {
            logger.info("Card created with id: ${it.id}")
        }
    }
}
