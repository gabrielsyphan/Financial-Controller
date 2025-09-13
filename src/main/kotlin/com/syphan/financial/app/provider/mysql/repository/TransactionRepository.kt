package com.syphan.financial.app.provider.mysql.repository

import com.syphan.financial.app.provider.mysql.model.TransactionModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.UUID

@Repository
interface TransactionRepository : JpaRepository<TransactionModel, UUID> {
    fun findTransactionsByDateBetween(
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<TransactionModel>
}
