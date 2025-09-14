package com.syphan.financial.app.controller.web

import com.syphan.financial.domain.usecase.FindAllCardsUseCase
import com.syphan.financial.domain.usecase.FindAllTransactionsUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/finances")
class FinancesController(
    private val findAllTransactionsUseCase: FindAllTransactionsUseCase,
    private val findAllCardsUseCase: FindAllCardsUseCase,
) {
    @GetMapping
    fun index(model: Model): String {
        val transactions = findAllTransactionsUseCase.execute()
        val cards = findAllCardsUseCase.execute()
        model.addAttribute("transactions", transactions)
        model.addAttribute("cards", cards)
        return "finances/index"
    }
}
