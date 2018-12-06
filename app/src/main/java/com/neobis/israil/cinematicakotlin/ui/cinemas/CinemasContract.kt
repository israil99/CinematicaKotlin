package com.neobis.israil.cinematicakotlin.ui.cinemas

import com.neobis.israil.cinematicakotlin.model.cinemas.Unmain
import com.neobis.israil.cinematicakotlin.utils.ProgBarInterface
import com.neobis.israil.cinematicakotlin.utils.SuccessOrError

interface CinemasContract {

    interface View : ProgBarInterface, SuccessOrError<List<Unmain>> {
        fun onMoviesResponse(result: Unmain)
    }

    interface Presenter {
        fun loadCinemas()
    }
}
