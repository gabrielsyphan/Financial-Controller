package com.syphan.financial.app.usecase

import com.syphan.financial.domain.usecase.RetrieveFileByNameUseCase
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RetrieveFileByNameUseCaseImpl(
    @Value("\${report.storage.path}")
    private val reportStoragePath: String,
) : RetrieveFileByNameUseCase {
    override fun execute(fileName: String): ByteArray {
        val filePath = "$reportStoragePath/$fileName"
        val file = java.io.File(filePath)
        if (!file.exists()) {
            throw org.springframework.http.HttpStatus.NOT_FOUND.let { status ->
                org.springframework.web.server
                    .ResponseStatusException(status, "Arquivo não encontrado")
            }
        }
        return file.readBytes()
    }
}
