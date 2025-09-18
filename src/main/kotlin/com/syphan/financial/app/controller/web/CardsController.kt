package com.syphan.financial.app.controller.web

import com.syphan.financial.app.util.WebPathConstants
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(WebPathConstants.CARDS)
class CardsController {
    @RequestMapping
    fun get(model: Model): String {
        model.addAttribute("pageTitle", "Cards")
        model.addAttribute("activePage", "cards")
        return "cards/index"
    }
}
