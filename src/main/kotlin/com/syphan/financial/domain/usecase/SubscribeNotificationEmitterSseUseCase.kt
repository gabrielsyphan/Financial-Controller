package com.syphan.financial.domain.usecase

interface SubscribeNotificationEmitterSseUseCase<T> {
    fun execute(): T
}
