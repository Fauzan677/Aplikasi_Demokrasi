package com.example.oneboarding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class berita(
    var imgBerita: Int,
    var nameBerita: String,
//    var desc: String,

    ) : Parcelable
