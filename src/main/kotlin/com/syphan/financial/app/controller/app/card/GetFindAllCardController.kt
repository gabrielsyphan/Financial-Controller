package com.syphan.financial.app.controller.app.card

import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.entity.CardEntity
import com.syphan.financial.domain.usecase.FindAllCardsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.CARDS.ALL)
class GetFindAllCardController(
    private val findAllCardController: FindAllCardsUseCase,
) {
    @GetMapping
    fun execute(): ResponseEntity<List<CardEntity>> = ResponseEntity.ok(findAllCardController.execute())
}
