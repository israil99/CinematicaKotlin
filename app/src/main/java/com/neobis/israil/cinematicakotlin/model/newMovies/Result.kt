package com.neobis.israil.cinematicakotlin.model.newMovies

import android.os.Parcel
import android.os.Parcelable

data class Result(
        val id: Int,
        val name: String,
        val url: String,
        val image: String,
        val countries: String,
        val actors: String,
        val rejisser: String,
        val comments_count: String,
        val reviews_count: Int,
        val trailers_count: Int,
        val photos_count: Int,
        val sess_has: Int,
        val before: String,
        val entered: String
):Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeString(image)
        parcel.writeString(countries)
        parcel.writeString(actors)
        parcel.writeString(rejisser)
        parcel.writeString(comments_count)
        parcel.writeInt(reviews_count)
        parcel.writeInt(trailers_count)
        parcel.writeInt(photos_count)
        parcel.writeInt(sess_has)
        parcel.writeString(before)
        parcel.writeString(entered)
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