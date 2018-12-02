package com.neobis.israil.cinematicakotlin.ui.new_movies


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.neobis.israil.cinematicakotlin.R
import com.neobis.israil.cinematicakotlin.model.newMovies.Result
import com.neobis.israil.cinematicakotlin.utils.Helper
import kotlinx.android.synthetic.main.movie_card.view.*

class NewMoviesAdapter(var list: MutableList<Any>, private var listener: Listener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder)
            holder.bind(list.get(position) as Result)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Result) {
            itemView.textview_cinema_name.text = post.name
            Glide.with(itemView.context)
                    .load(Helper.makeImageBetter("http://kinoafisha.ua/"+ post.image))
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(itemView.cinema_image)

            itemView.tag = post
/*
          *//*

            itemView.tag = post
            itemView.setOnClickListener { v ->
                val mPost = v.tag as Post
                listener.onPostClicked(mPost)*//*
            }*/
        }
    }


    interface Listener {
        fun onPostClicked(movie: Result)
    }

    fun setPostList(otherList: MutableList<Any>) {
        list = otherList;
        notifyDataSetChanged()
    }


}
