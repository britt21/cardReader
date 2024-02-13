package com.example.cardreader.data.card_info.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bank(
    val name: String? = ""
): Parcelable