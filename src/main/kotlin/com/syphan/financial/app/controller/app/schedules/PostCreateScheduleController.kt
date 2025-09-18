package com.syphan.financial.app.controller.app.schedules

import com.syphan.financial.app.controller.app.schedules.request.CreateScheduleRequest
import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.command.CreateScheduleCommand
import com.syphan.financial.domain.entity.ScheduleEntity
import com.syphan.financial.domain.usecase.CreateScheduleUseCase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.SCHEDULES.CREATE)
class PostCreateScheduleController(
    private val createScheduleUseCase: CreateScheduleUseCase,
) {
    @PostMapping
    fun execute(
        @RequestBody @Valid request: CreateScheduleRequest,
    ): ResponseEntity<ScheduleEntity> {
        val response =
            createScheduleUseCase.execute(
                CreateScheduleCommand(
                    title = request.title,
                    date = request.date,
                    description = request.description,
                    startTime = request.startTime,
                    endTime = request.endTime,
                    isTransaction = request.isTransaction,
                    transactionValue = request.transactionValue,
                    shouldRepeat = request.shouldRepeat,
                    numberOfRepetitions = request.numberOfRepetitions,
                    repetitionType = request.repetitionType,
                ),
            )
        return ResponseEntity.ok(response)
    }
}
