package com.syphan.financial.app.controller.app.transactions

import com.syphan.financial.app.controller.app.transactions.request.RemoveTransactionByIdRequest
import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.usecase.RemoveTransactionByIdUseCase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.TRANSACTIONS.REMOVE)
class DeleteRemoveTransactionByIdController(
    private val removeTransactionByIdUseCase: RemoveTransactionByIdUseCase,
) {
    @DeleteMapping
    fun execute(
        @RequestBody @Valid request: RemoveTransactionByIdRequest,
    ): ResponseEntity<Void> {
        removeTransactionByIdUseCase.execute(
            transactionId = request.transactionId,
        )
        return ResponseEntity.noContent().build()
    }
}
