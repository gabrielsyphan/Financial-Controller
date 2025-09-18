package com.syphan.financial.app.controller.app.transactions.request

import java.util.UUID

data class RemoveTransactionByIdRequest(
    val transactionId: UUID,
)
