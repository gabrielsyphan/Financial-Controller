package com.syphan.financial.domain.entity

import com.syphan.financial.domain.entity.enums.TransactionType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class TransactionEntity(
    val id: UUID,
    val transactionType: TransactionType,
    val amount: BigDecimal,
    val description: String,
    val date: LocalDate,
    val card: CardEntity?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
)
