package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.entity.TransactionEntity

interface FindAllTransactionsUseCase {
    fun execute(): List<TransactionEntity>
}
