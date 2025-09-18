package com.syphan.financial.app.controller.app.transactions

import com.syphan.financial.app.controller.app.transactions.request.CreateTransactionRequest
import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.command.CreateTransactionCommand
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.usecase.CreateTransactionUseCase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.TRANSACTIONS.CREATE)
class PostCreateTransactionController(
    private val createTransactionUseCase: CreateTransactionUseCase,
) {
    @PostMapping
    fun execute(
        @RequestBody @Valid request: CreateTransactionRequest,
    ): ResponseEntity<TransactionEntity> {
        val response =
            createTransactionUseCase.execute(
                CreateTransactionCommand(
                    cardId = request.cardId,
                    amount = request.amount,
                    description = request.description,
                    transactionType = request.transactionType,
                    date = request.date,
                ),
            )
        return ResponseEntity.ok(response)
    }
}
