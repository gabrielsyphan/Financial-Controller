package com.syphan.financial.domain.entity

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class ReportEntity(
    val id: UUID,
    val filePath: String,
    val fileName: String,
    val fileType: String,
    val fileSize: Long,
    val periodStart: LocalDate,
    val periodEnd: LocalDate,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
)
