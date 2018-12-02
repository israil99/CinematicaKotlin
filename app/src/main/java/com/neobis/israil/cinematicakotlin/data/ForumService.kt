package com.neobis.israil.cinematicakotlin.data

import com.neobis.israil.cinematicakotlin.model.cinemas.Cinemas
import com.neobis.israil.cinematicakotlin.model.movies.Main
import com.neobis.israil.cinematicakotlin.model.movies.Result
import com.neobis.israil.cinematicakotlin.model.newMovies.Movies
import retrofit2.Call
import retrofit2.http.GET



interface ForumService {

    @GET("/ajax/kinoafisha_load/")
    fun readMovieArray(): Call<Main>


    @GET("/ajax/skoro_load")
    fun readNewMoviesList(): Call<Movies>


    @GET("/ajax/kinoteatrs_load")
    fun readCinemaList(): Call<Cinemas>
}

