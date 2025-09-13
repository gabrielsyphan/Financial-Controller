package com.syphan.financial.domain.command

import com.syphan.financial.domain.entity.enums.TransactionType
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class CreateTransactionCommand(
    val transactionType: TransactionType,
    val amount: BigDecimal,
    val description: String,
    val date: LocalDate,
    val cardId: UUID? = null,
)
