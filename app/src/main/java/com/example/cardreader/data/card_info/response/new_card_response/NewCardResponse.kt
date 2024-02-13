package com.example.cardreader.data.card_info.response.new_card_response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NewCardResponse(
    val bank: Bank? = Bank(),
    val category: String? = "",
    val country: Country? = Country(),
    val number: Number? = Number(),
    val scheme: String? = "",
    val success: Boolean? = false,
    val type: String? = ""
): Parcelable