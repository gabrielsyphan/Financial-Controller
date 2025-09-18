package com.syphan.financial.app.controller.app.cards.request

import com.syphan.financial.domain.entity.enums.CardType
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero
import java.math.BigDecimal

data class CreateCardRequest(
    @param:NotBlank(message = "Name must not be blank")
    val name: String,
    @param:NotNull(message = "Card type must not be null")
    val type: CardType,
    @param:NotNull(message = "Limit Amount must not be null")
    @param:PositiveOrZero(message = "Limit amount must be zero or positive")
    val limitAmount: BigDecimal?,
    @param:NotNull(message = "isActive must not be null")
    val isActive: Boolean,
)
