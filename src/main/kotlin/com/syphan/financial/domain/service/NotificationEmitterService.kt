package com.syphan.financial.domain.service

import com.syphan.financial.domain.entity.NotificationEntity

interface NotificationEmitterService<T> {
    fun subscribe(): T

    fun execute(notification: NotificationEntity)

    fun removeEmitter(emitter: T)
}
