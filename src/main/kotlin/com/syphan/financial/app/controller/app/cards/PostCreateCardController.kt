package com.syphan.financial.app.controller.app.cards

import com.syphan.financial.app.controller.app.cards.request.CreateCardRequest
import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.command.CreateCardCommand
import com.syphan.financial.domain.entity.CardEntity
import com.syphan.financial.domain.usecase.CreateCardUseCase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.CARDS.CREATE)
class PostCreateCardController(
    private val createCardUseCase: CreateCardUseCase,
) {
    @PostMapping
    fun execute(
        @RequestBody @Valid request: CreateCardRequest,
    ): ResponseEntity<CardEntity> {
        val response =
            createCardUseCase.execute(
                CreateCardCommand(
                    name = request.name,
                    type = request.type,
                    limitAmount = request.limitAmount,
                    isActive = request.isActive,
                ),
            )
        return ResponseEntity.ok(response)
    }
}
