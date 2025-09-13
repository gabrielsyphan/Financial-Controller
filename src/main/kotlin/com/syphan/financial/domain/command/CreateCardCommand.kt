package com.syphan.financial.domain.command

import com.syphan.financial.domain.entity.enums.CardType
import java.math.BigDecimal

data class CreateCardCommand(
    val name: String,
    val type: CardType,
    val limitAmount: BigDecimal?,
    val isActive: Boolean,
)
