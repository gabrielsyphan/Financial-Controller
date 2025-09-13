package com.syphan.financial.domain.entity.enums

enum class TransactionType(
    val description: String,
) {
    INCOME("Money received"),
    EXPENSE("Money spent"),
    TRANSFER_IN("Money received from another account"),
    TRANSFER_OUT("Money sent to another account"),
    INVESTMENT_BUY("Investing (stocks, funds, CDB, etc.)"),
    INVESTMENT_SELL("Selling or redeeming investments"),
    ADJUSTMENT("Manual balance adjustment"),
}
