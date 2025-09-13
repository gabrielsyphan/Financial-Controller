package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.command.CreateTransactionCommand
import com.syphan.financial.domain.entity.TransactionEntity

interface CreateTransactionUseCase {
    fun execute(transactionCommand: CreateTransactionCommand): TransactionEntity
}
