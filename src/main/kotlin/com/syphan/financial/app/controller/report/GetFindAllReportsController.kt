package com.syphan.financial.app.controller.report

import com.syphan.financial.app.util.PathConstants
import com.syphan.financial.domain.entity.ReportEntity
import com.syphan.financial.domain.usecase.FindAllReportsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(PathConstants.REPORTS.ALL)
class GetFindAllReportsController(
    private val findAllReportsUseCase: FindAllReportsUseCase,
) {
    @GetMapping()
    fun execute(): ResponseEntity<List<ReportEntity>> = ResponseEntity.ok().body(findAllReportsUseCase.execute())
}
