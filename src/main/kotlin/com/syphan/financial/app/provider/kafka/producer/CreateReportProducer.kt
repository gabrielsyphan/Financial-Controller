package com.syphan.financial.app.provider.kafka.producer

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.syphan.financial.domain.entity.TransactionEntity
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class CreateReportProducer(
    @Value("\${spring.kafka.topic.create-report}")
    private val topic: String,
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    fun execute(message: List<TransactionEntity>) {
        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())
        val payload = mapper.writeValueAsString(message)
        kafkaTemplate.send(topic, payload)
    }
}
