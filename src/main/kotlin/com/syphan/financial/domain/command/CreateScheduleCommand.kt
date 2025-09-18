package com.syphan.financial.domain.command

import com.syphan.financial.domain.entity.enums.RepetitionType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime

data class CreateScheduleCommand(
    val title: String,
    val date: LocalDate,
    val description: String?,
    val startTime: LocalTime?,
    val endTime: LocalTime?,
    val isTransaction: Boolean,
    val transactionValue: BigDecimal?,
    val shouldRepeat: Boolean,
    val numberOfRepetitions: Int,
    val repetitionType: RepetitionType?,
)
