package com.syphan.financial.app.controller.report.request

import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class CreateReportByPeriodRequest(
    @param:NotNull("Start date is required")
    val startDate: LocalDate,
    @param:NotNull("End date is required")
    val endDate: LocalDate,
)
