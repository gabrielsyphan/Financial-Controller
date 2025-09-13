package com.syphan.financial.app.util

object PathConstants {
    const val API_V1 = "/api/v1"

    object TRANSACTIONS {
        const val BASE = "$API_V1/transactions"
        const val CRATE = "$BASE/create"
        const val ALL = "$BASE/all"
    }

    object CARDS {
        const val BASE = "$API_V1/cards"
        const val CREATE = "$BASE/create"
        const val ALL = "$BASE/all"
    }

    object REPORTS {
        const val BASE = "$API_V1/reports"
        const val CREATE_BY_PERIOD = "$BASE/create-by-period"
    }
}
