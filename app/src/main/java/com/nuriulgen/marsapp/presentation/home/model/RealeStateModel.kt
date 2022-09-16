package com.nuriulgen.marsapp.presentation.home.model

import android.os.Parcelable


@RealeStateModel.Parcelize
data class RealeStateModel(

    val price: Int,
    val id: String,
    val type: String,
    val img_src: String
) {
    annotation class Parcelize
}



