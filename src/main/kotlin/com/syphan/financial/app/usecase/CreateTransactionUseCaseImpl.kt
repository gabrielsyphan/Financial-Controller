package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toTransactionEntity
import com.syphan.financial.app.provider.mysql.model.toTransactionModel
import com.syphan.financial.app.provider.mysql.repository.CardRepository
import com.syphan.financial.app.provider.mysql.repository.TransactionRepository
import com.syphan.financial.domain.command.CreateTransactionCommand
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.usecase.CreateTransactionUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class CreateTransactionUseCaseImpl(
    private val transactionRepository: TransactionRepository,
    private val cardRepository: CardRepository,
) : CreateTransactionUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(transactionCommand: CreateTransactionCommand): TransactionEntity {
        logger.info("Creating transaction with command: $transactionCommand")
        val card = transactionCommand.cardId?.let { id -> cardRepository.findById(id) }?.getOrNull()
        return transactionRepository.save(transactionCommand.toTransactionModel(card)).toTransactionEntity().also {
            logger.info("Transaction created with id: ${it.id}")
        }
    }
}
