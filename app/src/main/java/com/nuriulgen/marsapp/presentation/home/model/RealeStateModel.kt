package com.nuriulgen.marsapp.presentation.home.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RealeStateModel(

    val price: Int,
    val id: String,
    val type: String,
    val img_src: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(price)
        parcel.writeString(id)
        parcel.writeString(type)
        parcel.writeString(img_src)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RealeStateModel> {
        override fun createFromParcel(parcel: Parcel): RealeStateModel {
            return RealeStateModel(parcel)
        }

        override fun newArray(size: Int): Array<RealeStateModel?> {
            return arrayOfNulls(size)
        }
    }
}


