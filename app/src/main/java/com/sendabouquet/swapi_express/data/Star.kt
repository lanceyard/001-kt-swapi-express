package com.sendabouquet.swapi_express.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Star(
    val title: String,
    val secondary: String,
    val support: String,
    val photo: String
) : Parcelable
