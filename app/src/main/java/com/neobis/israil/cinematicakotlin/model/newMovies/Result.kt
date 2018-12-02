package com.neobis.israil.cinematicakotlin.model.newMovies

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
        val is3d: Any,
        val before: String,
        val entered: String,
        val worldwide: Any,
        val is_b: Boolean,
        val b_link: Boolean,
        val age_limit: Any
)