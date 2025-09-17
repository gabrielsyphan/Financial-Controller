package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.repository.TransactionRepository
import com.syphan.financial.domain.usecase.RemoveTransactionByIdUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class RemoveTransactionByIdUseCase(
    private val transactionRepository: TransactionRepository,
) : RemoveTransactionByIdUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(transactionId: UUID) {
        logger.info("Removing transaction with id: $transactionId")
        transactionRepository.deleteById(transactionId)
        logger.info("Transaction with id: $transactionId removed successfully")
    }
}
