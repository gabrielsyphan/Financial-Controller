package com.syphan.financial.domain.usecase

interface RetrieveFileByNameUseCase {
    fun execute(fileName: String): ByteArray
}
