package com.syphan.financial.app.controller.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/finances")
class FinancesController {
    @GetMapping
    fun index(): String = "finances/index"
}
