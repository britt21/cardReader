package com.example.cardreader.data.card_info.response

data class CardInfoResponse(
    val bank: Bank? = Bank(),
    val brand: String? = "",
    val country: Country? = Country(),
    val number: Number? = Number(),
    val scheme: String? = "",
    val type: String? = ""
)