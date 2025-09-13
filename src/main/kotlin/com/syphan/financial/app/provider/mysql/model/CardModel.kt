package com.syphan.financial.app.provider.mysql.model

import com.syphan.financial.domain.command.CreateCardCommand
import com.syphan.financial.domain.entity.CardEntity
import com.syphan.financial.domain.entity.enums.CardType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "cards")
data class CardModel(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(name = "name", nullable = false, length = 100)
    val name: String,
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    val type: CardType,
    @Column(name = "limit_amount", nullable = true, precision = 19, scale = 2)
    val limitAmount: BigDecimal?,
    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN", length = 1)
    val isActive: Boolean,
    @OneToMany(mappedBy = "card")
    val transactions: List<TransactionModel> = emptyList(),
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDateTime? = null,
)

fun CreateCardCommand.toCardModel() =
    CardModel(
        name = this.name,
        type = this.type,
        limitAmount = this.limitAmount,
        isActive = this.isActive,
    )

fun CardModel.toCardEntity() =
    CardEntity(
        id = this.id,
        name = this.name,
        type = this.type,
        limitAmount = this.limitAmount,
        isActive = this.isActive,
        transactions = this.transactions.map { it.toTransactionEntityWithoutCard() },
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )

fun CardModel.toCardEntityWithoutTransactions() =
    CardEntity(
        id = this.id,
        name = this.name,
        type = this.type,
        limitAmount = this.limitAmount,
        isActive = this.isActive,
        transactions = emptyList(),
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
