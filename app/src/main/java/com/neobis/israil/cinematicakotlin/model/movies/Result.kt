package com.neobis.israil.cinematicakotlin.model.movies

import android.os.Parcel
import android.os.Parcelable

data class Result(
        val id: Int,
        val name: String,
        val url: String,
        val image: String,
        val vote: String,
        val count_vote: String,
        val imdb: Boolean,
        val countries: String,
        val actors: String,
        val rejisser: String,
        val premier_ua: String,
        val sessions: List<Session>

):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(Session)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeString(image)
        parcel.writeString(vote)
        parcel.writeString(count_vote)
        parcel.writeByte(if (imdb) 1 else 0)
        parcel.writeString(countries)
        parcel.writeString(actors)
        parcel.writeString(rejisser)
        parcel.writeString(premier_ua)
        parcel.writeTypedList(sessions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}
