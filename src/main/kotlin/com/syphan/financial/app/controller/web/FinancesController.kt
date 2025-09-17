package com.syphan.financial.app.controller.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.syphan.financial.domain.usecase.FindAllTransactionsUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.math.BigDecimal

@Controller
@RequestMapping("/finances")
class FinancesController(
    private val findAllTransactionsUseCase: FindAllTransactionsUseCase,
) {
    @GetMapping
    fun index(model: Model): String {
        val transactions = findAllTransactionsUseCase.execute().sortedBy { it.date }
        val totalTransactionated = transactions.sumOf { it.amount }
        val totalPositive = transactions.filter { it.transactionType.isPositive }.sumOf { it.amount } // DOUBLE
        val totalNegative = transactions.filter { it.transactionType.isPositive.not() }.sumOf { it.amount }
        val positiveChange = totalPositive.multiply(BigDecimal(100)).divide(totalTransactionated, 2, java.math.RoundingMode.HALF_UP)
        val negativeChange = totalNegative.multiply(BigDecimal(100)).divide(totalTransactionated, 2, java.math.RoundingMode.HALF_UP)

        val objectMapper = ObjectMapper().registerModule(JavaTimeModule())
        val transactionsJson = objectMapper.writeValueAsString(transactions)

        model.addAttribute("transactionsJson", transactionsJson)
        model.addAttribute("transactions", transactions)
        model.addAttribute("totalFunds", totalPositive - totalNegative)
        model.addAttribute("totalPositive", totalPositive)
        model.addAttribute("positiveChange", positiveChange)
        model.addAttribute("totalNegative", totalNegative)
        model.addAttribute("negativeChange", negativeChange)
        model.addAttribute("totalTransactionated", totalTransactionated)
        return "finances/index"
    }
}
