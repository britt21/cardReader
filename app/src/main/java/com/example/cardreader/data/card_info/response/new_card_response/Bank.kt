package com.example.cardreader.data.card_info.response.new_card_response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Bank(
    val name: String? = "",
    val phone: String? = "",
    val url: String? = ""
):Parcelable