package com.example.cardreader.data.card_info.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Country(
    val alpha2: String? = "",
    val currency: String? = "",
    val emoji: String? = "",
    val latitude: Int? = 0,
    val longitude: Int? = 0,
    val name: String? = "",
    val numeric: String? = ""
): Parcelable