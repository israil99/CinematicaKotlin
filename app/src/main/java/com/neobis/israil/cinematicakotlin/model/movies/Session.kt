package com.neobis.israil.cinematicakotlin.model.movies

import android.os.Parcel
import android.os.Parcelable

data class Session(
        val k_id: String,
        val k_name: String,
        val k_addr: String,
        val k_url: String,
        val k_type: String,
        val k_bron: String,
        val k_adv: Boolean

):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(k_id)
        parcel.writeString(k_name)
        parcel.writeString(k_addr)
        parcel.writeString(k_url)
        parcel.writeString(k_type)
        parcel.writeString(k_bron)
        parcel.writeByte(if (k_adv) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Session> {
        override fun createFromParcel(parcel: Parcel): Session {
            return Session(parcel)
        }

        override fun newArray(size: Int): Array<Session?> {
            return arrayOfNulls(size)
        }
    }
}