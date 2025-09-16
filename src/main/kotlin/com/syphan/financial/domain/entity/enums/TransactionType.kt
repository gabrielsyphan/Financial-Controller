package com.syphan.financial.domain.entity.enums

enum class TransactionType(
    val description: String,
    val isPositive: Boolean,
    val portugueseTranslation: String,
) {
    INCOME("Money received", true, "Entrada"),
    EXPENSE("Money spent", false, "Saída"),
    TRANSFER_IN("Money received from another account", true, "Transferência Recebida"),
    TRANSFER_OUT("Money sent to another account", false, "Transferência Enviada"),
    INVESTMENT_BUY("Investing (stocks, funds, CDB, etc.)", false, "Investimento"),
    INVESTMENT_SELL("Selling or redeeming investments", true, "Resgate"),
    ADJUSTMENT("Manual balance adjustment", false, "Ajuste de Saldo"),
    ;

    fun friendlyName(): String = name.lowercase().replaceFirstChar { it.uppercase() }
}
