package com.syphan.financial.app.controller.web

import com.syphan.financial.app.provider.mysql.repository.ScheduleRepository
import com.syphan.financial.app.util.WebPathConstants
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(WebPathConstants.SCHEDULES)
class SchedulesController(
    private val scheduleRepository: ScheduleRepository,
) {
    @RequestMapping
    fun get(model: Model): String {
        val schedules = scheduleRepository.findAll()

        model.addAttribute("schedules", schedules)
        model.addAttribute("pageTitle", "Schedules")
        model.addAttribute("activePage", "schedules")
        return "schedules/index"
    }
}
