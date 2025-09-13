package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toEntity
import com.syphan.financial.app.provider.mysql.repository.ReportRepository
import com.syphan.financial.domain.entity.ReportEntity
import com.syphan.financial.domain.usecase.FindAllReportsUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class FindAllReportsUseCaseImpl(
    private val reportRepository: ReportRepository,
) : FindAllReportsUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(): List<ReportEntity> {
        logger.info("Finding all reports")
        return reportRepository.findAll().map { it.toEntity() }.also {
            logger.info("Found ${it.size} reports")
        }
    }
}
