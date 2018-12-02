package com.neobis.israil.cinematicakotlin.ui.new_movies

import android.util.Log
import com.neobis.israil.cinematicakotlin.R
import com.neobis.israil.cinematicakotlin.StartApplication
import com.neobis.israil.cinematicakotlin.model.newMovies.Movies
import com.neobis.israil.cinematicakotlin.utils.Connection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewMoviesPresenter (val view: NewMoviesContract.View?) : NewMoviesContract.Presenter{
    override fun loadNewMovies() {
        if (!Connection.isNetworkOnline()) {
            Log.d("Network","Error")
            view?.onError(StartApplication.INSTANCE.getString(R.string.error_network))
            return
        }
        Log.d("OK","Connection")
        view?.showProgress()
        StartApplication.service.readNewMoviesList().enqueue(object : Callback<Movies> {


            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response!!.isSuccessful && response.body() != null) {
                    val list = response.body()!!.result
                    Log.d("Success",list.size.toString())
                    view?.onSuccess(list)
                } else {
                    Log.d("Error","Zapros ne proshel")
                    Log.d("presenter new movies","32")
                    view?.onError(StartApplication.INSTANCE.getString(R.string.error_response))

                }
                view?.hideProgress()
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                view?.onError(StartApplication.INSTANCE.getString(R.string.error_response))
                Log.d("presenter new movies",t.cause.toString())
                view?.hideProgress()
            }

        })


    }

}