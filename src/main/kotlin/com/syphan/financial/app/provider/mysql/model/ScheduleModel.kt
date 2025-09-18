package com.syphan.financial.app.provider.mysql.model

import com.syphan.financial.domain.command.CreateScheduleCommand
import com.syphan.financial.domain.entity.ScheduleEntity
import com.syphan.financial.domain.entity.enums.RepetitionType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID

@Entity
@Table(name = "schedules")
data class ScheduleModel(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(name = "title", nullable = false, length = 100)
    val title: String,
    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    val date: LocalDate,
    @Column(name = "description", nullable = true, length = 255)
    val description: String?,
    @Column(name = "start_time", nullable = true, columnDefinition = "TIME")
    val startTime: LocalTime?,
    @Column(name = "end_time", nullable = true, columnDefinition = "TIME")
    val endTime: LocalTime?,
    @Column(name = "is_transaction", nullable = false, columnDefinition = "BOOLEAN", length = 1)
    val isTransaction: Boolean,
    @Column(name = "transaction_value", nullable = true, precision = 19, scale = 2)
    val transactionValue: BigDecimal?,
    @Column(name = "should_repeat", nullable = false, columnDefinition = "BOOLEAN", length = 1)
    val shouldRepeat: Boolean,
    @Column(name = "number_of_repetitions", nullable = true)
    val numberOfRepetitions: Int,
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    val repetitionType: RepetitionType?,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDateTime? = null,
)

fun CreateScheduleCommand.toScheduleModel() =
    ScheduleModel(
        title = this.title,
        date = this.date,
        description = this.description,
        startTime = this.startTime,
        endTime = this.endTime,
        isTransaction = this.isTransaction,
        transactionValue = this.transactionValue,
        shouldRepeat = this.shouldRepeat,
        numberOfRepetitions = this.numberOfRepetitions,
        repetitionType = this.repetitionType,
    )

fun ScheduleModel.toScheduleEntity() =
    ScheduleEntity(
        id = this.id,
        title = this.title,
        date = this.date,
        description = this.description,
        startTime = this.startTime,
        endTime = this.endTime,
        isTransaction = this.isTransaction,
        transactionValue = this.transactionValue,
        shouldRepeat = this.shouldRepeat,
        numberOfRepetitions = this.numberOfRepetitions,
        repetitionType = this.repetitionType,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
