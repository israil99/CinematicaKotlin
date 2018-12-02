package com.neobis.israil.cinematicakotlin.model.newMovies


data class Movies(
    val succes: Boolean,
    val count: Int,
    val result: List<Result>
)

