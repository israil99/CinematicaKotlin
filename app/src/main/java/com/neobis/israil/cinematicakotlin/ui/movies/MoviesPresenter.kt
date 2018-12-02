package com.neobis.israil.cinematicakotlin.ui.movie

import android.util.Log
import com.neobis.israil.cinematicakotlin.R
import com.neobis.israil.cinematicakotlin.StartApplication
import com.neobis.israil.cinematicakotlin.model.movies.Main
import com.neobis.israil.cinematicakotlin.model.movies.Result
import com.neobis.israil.cinematicakotlin.ui.movies.MoviesContract
import com.neobis.israil.cinematicakotlin.utils.Connection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesPresenter (val view: MoviesContract.View?) : MoviesContract.Presenter{
    override fun loadMovies() {
        if (!Connection.isNetworkOnline()) {
            Log.d("Network","Error")
            view?.onError(StartApplication.INSTANCE.getString(R.string.error_network))
            return
    }
        Log.d("OK","Connection")
        view?.showProgress()
        StartApplication.service.readMovieArray().enqueue(object :Callback<Main>{


            override fun onResponse(call: Call<Main>, response: Response<Main>) {
                if (response!!.isSuccessful && response.body() != null) {
                    val list = response.body()!!.result
                    Log.d("Success",list.size.toString())
                    view?.onSuccess(list)
                } else {
                    Log.d("Error","Zapros ne proshel")
                    Log.d("presenter","37")
                    view?.onError(StartApplication.INSTANCE.getString(R.string.error_response))

                }
            view?.hideProgress()
            }

            override fun onFailure(call: Call<Main>, t: Throwable) {
                view?.onError(StartApplication.INSTANCE.getString(R.string.error_response))
                Log.d("presenter",t.cause.toString())
                view?.hideProgress()
            }

        })


    }
}