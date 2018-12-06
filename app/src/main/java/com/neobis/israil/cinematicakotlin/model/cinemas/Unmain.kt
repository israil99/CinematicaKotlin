package com.neobis.israil.cinematicakotlin.model.cinemas

import android.os.Parcel
import android.os.Parcelable

data class Unmain(
        val id: Int,
        val name: String,
        val url: String,
        val image: String,
        val vote: String,
        val count_vote: String,
        val phone: String,
        val address: String
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeString(image)
        parcel.writeString(vote)
        parcel.writeString(count_vote)
        parcel.writeString(phone)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Unmain> {
        override fun createFromParcel(parcel: Parcel): Unmain {
            return Unmain(parcel)
        }

        override fun newArray(size: Int): Array<Unmain?> {
            return arrayOfNulls(size)
        }
    }
}