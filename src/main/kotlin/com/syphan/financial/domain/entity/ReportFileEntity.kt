package com.syphan.financial.domain.entity

import java.time.LocalDate

data class ReportFileEntity(
    val filePath: String,
    val fileName: String,
    val fileType: String,
    val periodStart: LocalDate,
    val periodEnd: LocalDate,
)
