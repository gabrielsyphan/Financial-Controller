package com.syphan.financial.domain.entity.enums

enum class CardType(
    val friendlyName: String,
) {
    CREDIT("Credit"),
    DEBIT("Debit"),
    PREPAID("Prepaid"),
    CHARGE("Charge"),
    VIRTUAL("Virtual"),
}
