package com.syphan.financial.app.provider.kafka.consumer

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.usecase.CreateReportFileUsecase
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class CreateReportConsumer(
    private val createReportFileUsecase: CreateReportFileUsecase,
) {
    @KafkaListener(topics = ["create-report"], groupId = "financial-report-group")
    fun execute(message: String) {
        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())
        val request = mapper.readValue(message, object : TypeReference<List<TransactionEntity>>() {})
        createReportFileUsecase.execute(request)
    }
}
