package com.neobis.israil.cinematicakotlin
import android.app.Application
import com.neobis.israil.cinematicakotlin.data.ForumService
import com.neobis.israil.cinematicakotlin.data.Network
import com.neobis.israil.cinematicakotlin.utils.Helper

class StartApplication : Application() {
    companion object {
        @Volatile
        lateinit var INSTANCE: StartApplication
        lateinit var service: ForumService
        lateinit var weatherService: ForumService
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        service = Network.initService(Helper.BASE_URL)
    }

}
