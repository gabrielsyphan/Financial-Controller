package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toTransactionEntity
import com.syphan.financial.app.provider.mysql.repository.TransactionRepository
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.usecase.FindAllTransactionsUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class FindAllTransactionsUseCaseImpl(
    private val transactionRepository: TransactionRepository,
) : FindAllTransactionsUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(): List<TransactionEntity> {
        logger.info("Finding all transactions")
        return transactionRepository.findAll().map { it.toTransactionEntity() }.also {
            logger.info("Found ${it.size} transactions")
        }
    }
}
