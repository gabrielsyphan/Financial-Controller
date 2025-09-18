package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.command.CreateScheduleCommand
import com.syphan.financial.domain.entity.ScheduleEntity

interface CreateScheduleUseCase {
    fun execute(createScheduleCommand: CreateScheduleCommand): ScheduleEntity
}
