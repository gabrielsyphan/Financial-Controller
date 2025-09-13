package com.syphan.financial.app.util

object PathConstants {
    const val API = "/api/v1"

    object TRANSACTIONS {
        const val BASE = "$API/transactions"
        const val CRATE = "$BASE/create"
        const val ALL = "$BASE/all"
    }

    object CARDS {
        const val BASE = "$API/cards"
        const val CREATE = "$BASE/create"
        const val ALL = "$BASE/all"
    }

    object REPORTS {
        const val BASE = "$API/reports"
        const val CREATE_BY_PERIOD = "$BASE/create-by-period"
        const val ALL = "$BASE/all"
        const val FILES = "$BASE/files"
    }
}
