package com.syphan.financial.app.provider.mysql.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "reports")
data class ReportModel(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(name = "file_path", nullable = false, length = 255)
    val filePath: String,
    @Column(name = "file_name", nullable = false, length = 100)
    val fileName: String,
    @Column(name = "file_type", nullable = false, length = 20)
    val fileType: String,
    @Column(name = "period_start", nullable = false, columnDefinition = "TIMESTAMP")
    val periodStart: LocalDate,
    @Column(name = "period_end", nullable = false, columnDefinition = "TIMESTAMP")
    val periodEnd: LocalDate,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDateTime? = null,
)
