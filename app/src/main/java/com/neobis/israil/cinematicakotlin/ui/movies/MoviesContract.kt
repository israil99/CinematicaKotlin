package com.neobis.israil.cinematicakotlin.ui.movies

import com.neobis.israil.cinematicakotlin.model.movies.Result
import com.neobis.israil.cinematicakotlin.utils.ProgBarInterface
import com.neobis.israil.cinematicakotlin.utils.SuccessOrError

interface MoviesContract {
    interface View : ProgBarInterface, SuccessOrError<MutableList<Result>> {
        fun onMoviesResponse(result: Result)
    }

    interface Presenter {
        fun loadMovies()
    }
}