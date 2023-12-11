package com.example.oneboarding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class pemimpin(
    var imgPemimpin :Int,
    var nameWalikota : String,
    var priode : String,
) : Parcelable
