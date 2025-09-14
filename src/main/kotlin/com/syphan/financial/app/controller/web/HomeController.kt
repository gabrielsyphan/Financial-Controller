package com.syphan.financial.app.controller.web

import com.syphan.financial.app.util.WebPathConstants
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(WebPathConstants.FINANCES)
class HomeController {
    @RequestMapping
    fun index(): String = "finances/index"
}
