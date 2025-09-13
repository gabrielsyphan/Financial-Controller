package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toTransactionEntity
import com.syphan.financial.app.provider.mysql.repository.TransactionRepository
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.usecase.FindAllTransactionsUseCase
import org.springframework.stereotype.Service

@Service
class FindAllTransactionsUseCaseImpl(
    private val transactionRepository: TransactionRepository,
) : FindAllTransactionsUseCase {
    override fun execute(): List<TransactionEntity> = transactionRepository.findAll().map { it.toTransactionEntity() }
}
