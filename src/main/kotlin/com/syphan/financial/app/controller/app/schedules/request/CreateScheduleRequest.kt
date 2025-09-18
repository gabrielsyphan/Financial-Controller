package com.syphan.financial.app.controller.app.schedules.request

import com.syphan.financial.domain.entity.enums.RepetitionType
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime

data class CreateScheduleRequest(
    @param:NotBlank(message = "Title must not be blank")
    val title: String,
    @param:NotBlank(message = "Date must not be blank")
    val date: LocalDate,
    val description: String? = null,
    val startTime: LocalTime? = null,
    val endTime: LocalTime? = null,
    val isTransaction: Boolean = false,
    val transactionValue: BigDecimal? = null,
    val shouldRepeat: Boolean = false,
    val numberOfRepetitions: Int = 0,
    val repetitionType: RepetitionType? = null,
)
