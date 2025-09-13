package com.syphan.financial.app.provider.mysql.model

import com.syphan.financial.domain.command.CreateTransactionCommand
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.entity.enums.TransactionType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "transactions")
data class TransactionModel(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    val transactionType: TransactionType,
    @Column(name = "amount", nullable = false, precision = 19, scale = 2)
    val amount: BigDecimal,
    @Column(name = "description", nullable = false, length = 255)
    val description: String,
    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    val date: LocalDate,
    @ManyToOne
    @JoinColumn(name = "card_id")
    val card: CardModel? = null,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDateTime? = null,
)

fun CreateTransactionCommand.toTransactionModel(card: CardModel?) =
    TransactionModel(
        transactionType = this.transactionType,
        amount = this.amount,
        description = this.description,
        date = this.date,
        card = card,
    )

fun TransactionModel.toTransactionEntity() =
    TransactionEntity(
        id = this.id,
        transactionType = this.transactionType,
        amount = this.amount,
        description = this.description,
        date = this.date,
        card = this.card?.toCardEntityWithoutTransactions(),
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )

fun TransactionModel.toTransactionEntityWithoutCard() =
    TransactionEntity(
        id = this.id,
        transactionType = this.transactionType,
        amount = this.amount,
        description = this.description,
        date = this.date,
        card = null,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
