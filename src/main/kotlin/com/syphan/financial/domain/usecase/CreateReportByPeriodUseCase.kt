package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.command.CreateReportByPeriodCommand

interface CreateReportByPeriodUseCase {
    fun execute(createReportByPeriodCommand: CreateReportByPeriodCommand)
}
