package com.cobacobaaja.barvolume.ui.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataMTK (
    val panjang: String?,
    val lebar: String?,
    val tinggi: String?
) : Parcelable