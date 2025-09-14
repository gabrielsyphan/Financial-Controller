package com.syphan.financial.app.controller.app.transaction.request

import com.syphan.financial.domain.entity.enums.TransactionType
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class CreateTransactionRequest(
    @param:NotNull(message = "Transaction type must not be null")
    val transactionType: TransactionType,
    @param:NotNull(message = "Amount must not be null")
    @param:Positive(message = "Amount must be greater than zero")
    val amount: BigDecimal,
    @param:NotBlank(message = "Description must not be blank")
    val description: String,
    @param:NotNull(message = "Date must not be null")
    val date: LocalDate,
    val cardId: UUID? = null,
)
