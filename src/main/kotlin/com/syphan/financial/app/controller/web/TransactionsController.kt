package com.syphan.financial.app.controller.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.syphan.financial.app.util.WebPathConstants
import com.syphan.financial.domain.usecase.FindAllTransactionsUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.math.BigDecimal

@Controller
@RequestMapping(WebPathConstants.TRANSACTIONS)
class TransactionsController(
    private val findAllTransactionsUseCase: FindAllTransactionsUseCase,
) {
    @GetMapping
    fun index(model: Model): String {
        val transactions = findAllTransactionsUseCase.execute().sortedBy { it.date }
        val totalTransactionated = transactions.sumOf { it.amount }
        val totalPositive =
            if (transactions.isEmpty().not()) {
                transactions
                    .filter {
                        it.transactionType.isPositive
                    }.sumOf { it.amount }
            } else {
                BigDecimal.ZERO
            }
        val totalNegative =
            if (transactions.isEmpty().not()) {
                transactions
                    .filter {
                        it.transactionType.isPositive.not()
                    }.sumOf { it.amount }
            } else {
                BigDecimal.ZERO
            }
        val positiveChange =
            if (transactions.isEmpty().not()) {
                totalPositive
                    .multiply(
                        BigDecimal(100),
                    ).divide(totalTransactionated, 2, java.math.RoundingMode.HALF_UP)
            } else {
                BigDecimal.ZERO
            }
        val negativeChange =
            if (transactions.isEmpty().not()) {
                totalNegative
                    .multiply(
                        BigDecimal(100),
                    ).divide(totalTransactionated, 2, java.math.RoundingMode.HALF_UP)
            } else {
                BigDecimal.ZERO
            }

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

        model.addAttribute("pageTitle", "Transactions")
        model.addAttribute("activePage", "transactions")

        return "transactions/index"
    }
}
