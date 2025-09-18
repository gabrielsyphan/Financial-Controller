package com.syphan.financial.domain.entity.enums

import java.time.DayOfWeek
import java.time.LocalDate

enum class RepetitionType {
    EVERY_DAY,
    EVERY_MONDAY,
    EVERY_TUESDAY,
    EVERY_WEDNESDAY,
    EVERY_THURSDAY,
    EVERY_FRIDAY,
    EVERY_SATURDAY,
    EVERY_SUNDAY,
    EVERY_WEEK,
    EVERY_MONTH,
    ;

    fun calculateNextDate(
        date: LocalDate,
        repeatCount: Int,
    ): LocalDate =
        when (this) {
            EVERY_DAY -> date.plusDays(repeatCount.toLong())
            EVERY_MONDAY -> date.plusWeeks(repeatCount.toLong()).with(DayOfWeek.MONDAY)
            EVERY_TUESDAY -> date.plusWeeks(repeatCount.toLong()).with(DayOfWeek.TUESDAY)
            EVERY_WEDNESDAY -> date.plusWeeks(repeatCount.toLong()).with(DayOfWeek.WEDNESDAY)
            EVERY_THURSDAY -> date.plusWeeks(repeatCount.toLong()).with(DayOfWeek.THURSDAY)
            EVERY_FRIDAY -> date.plusWeeks(repeatCount.toLong()).with(DayOfWeek.FRIDAY)
            EVERY_SATURDAY -> date.plusWeeks(repeatCount.toLong()).with(DayOfWeek.SATURDAY)
            EVERY_SUNDAY -> date.plusWeeks(repeatCount.toLong()).with(DayOfWeek.SUNDAY)
            EVERY_WEEK -> date.plusWeeks(repeatCount.toLong())
            EVERY_MONTH -> date.plusMonths(repeatCount.toLong())
        }
}
