package com.neobis.israil.cinematicakotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.neobis.israil.cinematicakotlin.utils.Helper
import kotlinx.android.synthetic.main.new_movie_details.*

@Suppress("DEPRECATION")
class NewMovieDetailsActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_movie_details)

        var name = intent.extras.getString("newMovieName")
        var image = "http://kinoafisha.ua/"+intent.extras.getString("newImage")
        var actors = " "+intent.extras.getString("newActors")
        var rejisser  = " "+intent.extras.getString("newRejisser")
        var countries = intent.extras.getString("newCountries")
        var mBefore = " "+intent.extras.getString("before")
        var countComm = " "+intent.extras.getString("countOfComm")


        Glide.with(applicationContext)
                .load(Helper.makeImageBest(image))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(new_movie_image)

        new_movie_name?.text = name
        new_movie_countries?.text = countries
        new_movie_actors?.text = Html.fromHtml("<b>"+getString(R.string.actors)+"</b>"+actors)
        new_movie_rejisser?.text = Html.fromHtml("<b>"+getString(R.string.rejisser)+"</b>"+rejisser)

        count_of_comments.text = (Html.fromHtml("<b>"+getString(R.string.CountOfComments)+"</b>"+countComm));
        before.text = (Html.fromHtml("<b>"+getString(R.string.before)+"</b>"+mBefore))
    }
}