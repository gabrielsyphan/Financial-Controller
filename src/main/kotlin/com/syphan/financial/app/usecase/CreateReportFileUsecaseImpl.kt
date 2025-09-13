package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.ReportModel
import com.syphan.financial.app.provider.mysql.repository.ReportRepository
import com.syphan.financial.domain.entity.ReportFileEntity
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.usecase.CreateReportFileUsecase
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.UUID

@Service
class CreateReportFileUsecaseImpl(
    private val reportRepository: ReportRepository,
    @Value("\${report.storage.path:/tmp/reports}")
    private val reportStoragePath: String,
) : CreateReportFileUsecase {
    override fun execute(transactions: List<TransactionEntity>) {
        val file = generateReportFile(transactions)

        reportRepository.save(
            ReportModel(
                filePath = file.filePath,
                fileName = file.fileName,
                fileType = file.fileType,
                periodStart = file.periodStart,
                periodEnd = file.periodEnd,
            ),
        )
    }

    fun generateReportFile(transactions: List<TransactionEntity>): ReportFileEntity {
        if (transactions.isEmpty()) throw IllegalArgumentException("No transactions to report")

        val fileName = "report_${UUID.randomUUID()}.csv"
        val filePath = Paths.get(reportStoragePath, fileName).toString()
        Files.createDirectories(Paths.get(reportStoragePath))
        File(filePath).bufferedWriter().use { out ->
            out.write("id,amount,date,description\n")
            transactions.forEach {
                out.write("${it.id},${it.amount},${it.date},${it.description}\n")
            }
        }
        return ReportFileEntity(
            filePath = filePath,
            fileName = fileName,
            fileType = "csv",
            periodStart = transactions.minOf { it.date },
            periodEnd = transactions.maxOf { it.date },
        )
    }
}
