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
        val comments_count: Int,
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
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString())


    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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