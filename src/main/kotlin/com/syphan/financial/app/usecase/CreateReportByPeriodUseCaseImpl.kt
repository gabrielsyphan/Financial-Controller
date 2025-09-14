package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.kafka.producer.CreateReportProducer
import com.syphan.financial.app.provider.mysql.model.toTransactionEntity
import com.syphan.financial.app.provider.mysql.repository.TransactionRepository
import com.syphan.financial.domain.command.CreateReportByPeriodCommand
import com.syphan.financial.domain.usecase.CreateReportByPeriodUseCase
import org.springframework.stereotype.Component

@Component
class CreateReportByPeriodUseCaseImpl(
    private val transactionRepository: TransactionRepository,
    private val createReportProducer: CreateReportProducer,
) : CreateReportByPeriodUseCase {
    override fun execute(createReportByPeriodCommand: CreateReportByPeriodCommand) =
        transactionRepository
            .findTransactionsByDateBetween(
                createReportByPeriodCommand.startDate,
                createReportByPeriodCommand.endDate,
            ).let { transactions ->
                createReportProducer.execute(
                    transactions.map { it.toTransactionEntity() },
                )
            }
}
