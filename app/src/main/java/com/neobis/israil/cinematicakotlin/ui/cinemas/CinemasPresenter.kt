package com.neobis.israil.cinematicakotlin.ui.cinemas

import android.util.Log
import com.neobis.israil.cinematicakotlin.R
import com.neobis.israil.cinematicakotlin.StartApplication
import com.neobis.israil.cinematicakotlin.model.cinemas.Cinemas
import com.neobis.israil.cinematicakotlin.utils.Connection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CinemasPresenter(val view: CinemasContract.View?) : CinemasContract.Presenter {

    override fun loadCinemas() {
        if (!Connection.isNetworkOnline()) {
            Log.d("Network", "Error")
            view?.onError(StartApplication.INSTANCE.getString(R.string.error_network))
            return
        }
        Log.d("OK", "Connection")
        view?.showProgress()

        StartApplication.service.readCinemaList().enqueue(object : Callback<Cinemas>{
            override fun onResponse(call: Call<Cinemas>, response: Response<Cinemas>) {

                if (response!!.isSuccessful && response.body() != null) {
                    val list = response.body()!!.result.unmain
                    Log.d("Success",list.size.toString())
                    view?.onSuccess(list)

                } else {
                    Log.d("Error","Zapros ne proshel")
                    Log.d("presenter","37")
                    view?.onError(StartApplication.INSTANCE.getString(R.string.error_response))
                }
                view?.hideProgress()

            }


            override fun onFailure(call: Call<Cinemas>, t: Throwable) {
                view?.onError(StartApplication.INSTANCE.getString(R.string.error_response))
                Log.d("presenter",t.cause.toString())
                view?.hideProgress()
            }

        })
    }
}