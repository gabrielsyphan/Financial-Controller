package com.syphan.financial.domain.usecase

import java.util.UUID

interface RemoveTransactionByIdUseCase {
    fun execute(transactionId: UUID)
}
