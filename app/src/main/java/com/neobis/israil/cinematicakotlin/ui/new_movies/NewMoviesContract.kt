package com.neobis.israil.cinematicakotlin.ui.new_movies

import com.neobis.israil.cinematicakotlin.model.newMovies.Result
import com.neobis.israil.cinematicakotlin.utils.ProgBarInterface
import com.neobis.israil.cinematicakotlin.utils.SuccessOrError

interface NewMoviesContract {
    interface View : ProgBarInterface, SuccessOrError<List<Result>> {
        fun onNewMoviesResponse(result: Result)
    }

    interface Presenter {
        fun loadNewMovies()
    }
}