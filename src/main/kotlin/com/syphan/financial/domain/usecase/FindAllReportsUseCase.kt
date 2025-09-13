package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.entity.ReportEntity

interface FindAllReportsUseCase {
    fun execute(): List<ReportEntity>
}
