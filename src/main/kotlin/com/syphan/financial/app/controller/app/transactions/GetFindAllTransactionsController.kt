package com.syphan.financial.app.controller.app.transactions

import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.entity.TransactionEntity
import com.syphan.financial.domain.usecase.FindAllTransactionsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.TRANSACTIONS.ALL)
class GetFindAllTransactionsController(
    private val findAllTransactionsUseCase: FindAllTransactionsUseCase,
) {
    @GetMapping
    fun execute(): ResponseEntity<List<TransactionEntity>> = ResponseEntity.ok(findAllTransactionsUseCase.execute())
}
