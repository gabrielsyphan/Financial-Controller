package com.syphan.financial.domain.entity

import com.syphan.financial.domain.entity.enums.RepetitionType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID

data class ScheduleEntity(
    val id: UUID,
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
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
)
