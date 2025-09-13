package com.syphan.financial.domain.usecase

import com.syphan.financial.domain.entity.TransactionEntity

interface CreateReportFileUsecase {
    fun execute(transactions: List<TransactionEntity>)
}
