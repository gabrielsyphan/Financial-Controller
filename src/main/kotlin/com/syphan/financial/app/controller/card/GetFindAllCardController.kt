package com.syphan.financial.app.controller.card

import com.syphan.financial.app.controller.card.request.CreateCardRequest
import com.syphan.financial.app.util.PathConstants
import com.syphan.financial.domain.command.CreateCardCommand
import com.syphan.financial.domain.entity.CardEntity
import com.syphan.financial.domain.usecase.CreateCardUseCase
import com.syphan.financial.domain.usecase.FindAllCardsUseCase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(PathConstants.CARDS.ALL)
class GetFindAllCardController(
    private val findAllCardController: FindAllCardsUseCase,
) {
    @GetMapping
    fun execute(): ResponseEntity<List<CardEntity>> = ResponseEntity.ok(findAllCardController.execute())
}
