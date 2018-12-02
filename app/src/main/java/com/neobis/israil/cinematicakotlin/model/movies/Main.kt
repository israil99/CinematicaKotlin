package com.neobis.israil.cinematicakotlin.model.movies

import android.os.Parcel
import android.os.Parcelable


data class Main(
        val succes: Boolean,
        val count: Int,
        val result: MutableList<Result>,
        val hash: Any
)

