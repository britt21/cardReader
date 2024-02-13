package com.example.cardreader.data.card_info.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CardInfoResponse(
    val bank: Bank? = Bank(),
    val brand: String? = "",
    val country: Country? = Country(),
    val scheme: String? = "",
    val type: String? = ""
): Parcelable