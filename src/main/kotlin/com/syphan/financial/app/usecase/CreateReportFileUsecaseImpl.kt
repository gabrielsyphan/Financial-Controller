package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.ReportModel
import com.syphan.financial.app.provider.mysql.repository.ReportRepository
import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.command.CreateNotificationCommand
import com.syphan.financial.domain.entity.ReportFileEntity
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.usecase.CreateNotificationUseCase
import com.syphan.financial.domain.usecase.CreateReportFileUsecase
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.UUID

@Component
class CreateReportFileUsecaseImpl(
    private val reportRepository: ReportRepository,
    @Value("\${report.storage.path}")
    private val reportStoragePath: String,
    private val createNotificationUseCase: CreateNotificationUseCase,
) : CreateReportFileUsecase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(transactions: List<TransactionEntity>) {
        logger.info("Generating report file for ${transactions.size} transactions")
        val file = generateReportFile(transactions)

        logger.info("Saving report file metadata to database")
        reportRepository
            .save(
                ReportModel(
                    id = file.id,
                    filePath = file.filePath,
                    fileName = file.fileName,
                    fileType = file.fileType,
                    fileSize = file.fileSize,
                    periodStart = file.periodStart,
                    periodEnd = file.periodEnd,
                ),
            ).also { logger.info("Report file metadata saved with id ${it.id}") }
        createNotificationUseCase.execute(
            CreateNotificationCommand(
                title = "Report Generated",
                message = "Your report file ${file.fileName} is ready for download.",
                link = file.filePath,
            ),
        )
    }

    fun generateReportFile(transactions: List<TransactionEntity>): ReportFileEntity {
        if (transactions.isEmpty()) throw IllegalArgumentException("No transactions to report")

        val fileId = UUID.randomUUID()
        val fileName = "report_$fileId.csv"
        val filePath = Paths.get(reportStoragePath, fileName).toString()
        Files.createDirectories(Paths.get(reportStoragePath))
        File(filePath).bufferedWriter().use { out ->
            out.write("id,amount,date,description\n")
            transactions.forEach {
                out.write("${it.id},${it.amount},${it.date},${it.description}\n")
            }
        }
        return ReportFileEntity(
            id = fileId,
            filePath = "${ApiPathConstants.REPORTS.FILES}/$fileName",
            fileName = fileName,
            fileType = "csv",
            fileSize = File(filePath).length(),
            periodStart = transactions.minOf { it.date },
            periodEnd = transactions.maxOf { it.date },
        )
    }
}
