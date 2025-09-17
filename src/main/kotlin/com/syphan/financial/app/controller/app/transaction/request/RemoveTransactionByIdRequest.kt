package com.syphan.financial.app.controller.app.transaction.request

import java.util.UUID

data class RemoveTransactionByIdRequest(
    val transactionId: UUID,
)
