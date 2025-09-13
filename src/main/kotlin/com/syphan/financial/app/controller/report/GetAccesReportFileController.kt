package com.syphan.financial.app.controller.report

import com.syphan.financial.app.util.PathConstants
import com.syphan.financial.domain.usecase.RetrieveFileByNameUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(PathConstants.REPORTS.FILES)
class GetAccesReportFileController(
    private val retrieveFileByNameUseCase: RetrieveFileByNameUseCase,
) {
    @GetMapping("/{fileName}")
    fun execute(
        @PathVariable fileName: String,
    ): ResponseEntity<ByteArray> {
        val file = retrieveFileByNameUseCase.execute(fileName)
        return ResponseEntity
            .ok()
            .header("Content-Disposition", "attachment; filename=\"$fileName\"")
            .body(file)
    }
}
