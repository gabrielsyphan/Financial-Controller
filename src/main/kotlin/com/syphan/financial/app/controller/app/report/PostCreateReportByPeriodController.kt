package com.syphan.financial.app.controller.app.report

import com.syphan.financial.app.controller.app.report.request.CreateReportByPeriodRequest
import com.syphan.financial.app.util.ApiPathConstants
import com.syphan.financial.domain.command.CreateReportByPeriodCommand
import com.syphan.financial.domain.usecase.CreateReportByPeriodUseCase
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiPathConstants.REPORTS.CREATE_BY_PERIOD)
class PostCreateReportByPeriodController(
    private val createReportByPeriodUseCase: CreateReportByPeriodUseCase,
) {
    @PostMapping
    fun execute(
        @RequestBody @Valid request: CreateReportByPeriodRequest,
    ): ResponseEntity<Void> {
        createReportByPeriodUseCase.execute(
            CreateReportByPeriodCommand(
                startDate = request.startDate,
                endDate = request.endDate,
            ),
        )
        return ResponseEntity.ok().build()
    }
}
