package com.example.cardreader.data.card_info.response.new_card_response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Number(
    val iin: String? = "",
    val length: Int? = 0,
    val luhn: Boolean? = false
): Parcelable