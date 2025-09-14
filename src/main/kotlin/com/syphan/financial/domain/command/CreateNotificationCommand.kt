package com.syphan.financial.domain.command

data class CreateNotificationCommand(
    val title: String,
    val message: String,
    val link: String? = null,
)
