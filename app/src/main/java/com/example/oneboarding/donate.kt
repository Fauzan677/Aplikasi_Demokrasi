package com.example.oneboarding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class donate(
    var imgDonate : Int,
    var heading : String,
) : Parcelable
