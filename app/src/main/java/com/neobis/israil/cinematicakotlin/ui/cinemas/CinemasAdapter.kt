package com.neobis.israil.cinematicakotlin.ui.cinemas

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.neobis.israil.cinematicakotlin.R
import com.neobis.israil.cinematicakotlin.model.cinemas.Unmain
import com.neobis.israil.cinematicakotlin.utils.Helper
import kotlinx.android.synthetic.main.cinema_card.view.*

class CinemasAdapter(var list: MutableList<Any>, private var listener: Listener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cinema_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder)
            holder.bind(list.get(position) as Unmain)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Unmain) {
            itemView.cinema_name.text = post.name
            Glide.with(itemView.context)
                    .load(Helper.makeImageBest("http://kinoafisha.ua/"+ post.image))
                    .dontTransform()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(itemView.cinema_img)
            itemView.cinema_address.text = post.address
            itemView.cinema_phone.text = post.phone
            itemView.tag = post


        }
    }


    interface Listener {
        fun onPostClicked(movie: Unmain)
    }

    fun setPostList(otherList: MutableList<Any>) {
        list = otherList;
        notifyDataSetChanged()
    }


}
