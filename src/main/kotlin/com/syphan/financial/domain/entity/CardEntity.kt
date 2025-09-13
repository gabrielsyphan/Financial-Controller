package com.syphan.financial.domain.entity

import com.syphan.financial.domain.entity.enums.CardType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class CardEntity(
    val id: UUID,
    val name: String,
    val type: CardType,
    val limitAmount: BigDecimal?,
    val isActive: Boolean,
    val transactions: List<TransactionEntity>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
)
