package com.syphan.financial.domain.command

import java.time.LocalDate

data class CreateReportByPeriodCommand(
    val startDate: LocalDate,
    val endDate: LocalDate,
)
