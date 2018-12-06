package com.neobis.israil.cinematicakotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.neobis.israil.cinematicakotlin.utils.Helper
import kotlinx.android.synthetic.main.movie_details.*

@Suppress("DEPRECATION")
class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        var name = intent.extras.getString("movieName")
        var image = "http://kinoafisha.ua/"+intent.extras.getString("image")
        var actors = " "+intent.extras.getString("actors")
        var rejisser  = " "+intent.extras.getString("rejisser")
        var countries = intent.extras.getString("countries")
        var vote = " "+intent.extras.getString("vote")
        var countVotes = " "+intent.extras.getString("count")

        Glide.with(applicationContext)
                .load(Helper.makeImageBest(image))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(movie_image)

        movie_name?.text = name
        movie_countries?.text = countries
        movie_actors?.text = Html.fromHtml("<b>"+getString(R.string.actors)+"</b>"+actors)
        movie_rejisser?.text = Html.fromHtml("<b>"+getString(R.string.rejisser)+"</b>"+rejisser)
        votes?.text= Html.fromHtml("<b>"+getString(R.string.vote)+"</b>"+vote)
        count_of_votes?.text = Html.fromHtml("<b>"+getString(R.string.countOfVotes)+"</b>"+countVotes)
    }
}