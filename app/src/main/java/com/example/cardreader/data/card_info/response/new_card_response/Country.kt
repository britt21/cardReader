package com.example.cardreader.data.card_info.response.new_card_response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Country(
    val alpha2: String? = "",
    val alpha3: String? = "",
    val emoji: String? = "",
    val name: String? = ""
): Parcelable