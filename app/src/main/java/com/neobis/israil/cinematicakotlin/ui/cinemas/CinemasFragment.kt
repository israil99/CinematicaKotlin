package com.neobis.israil.cinematicakotlin.ui.cinemas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neobis.israil.cinematicakotlin.R
import com.neobis.israil.cinematicakotlin.model.cinemas.Unmain
import kotlinx.android.synthetic.main.fragment_cinemas.*
import kotlinx.android.synthetic.main.fragment_movies.*

class CinemasFragment : Fragment(),CinemasContract.View, CinemasAdapter.Listener {



    private var presenter: CinemasContract.Presenter? = null
    private var adapter: CinemasAdapter? = null
    private var list: MutableList<Any> = ArrayList()
    private var isSelectedElements = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cinemas,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        recycler_view3.layoutManager = LinearLayoutManager(activity)

        adapter = CinemasAdapter(list, this)
        recycler_view3.adapter = adapter
        presenter = CinemasPresenter(this)

        presenter?.loadCinemas()

        swipeRefresh3.setOnRefreshListener {

            presenter?.loadCinemas()

        }
    }




    override fun onMoviesResponse(result: Unmain) {
    //
    }

    override fun showProgress() {
        swipeRefresh3?.isRefreshing = true
    }

    override fun hideProgress() {
        swipeRefresh3?.isRefreshing = false
        isSelectedElements = false
    }

    override fun onSuccess(result: List<Unmain>) {
        this.list.addAll(result)
        adapter?.setPostList(this.list)
        recycler_view3.adapter = adapter
    }

    override fun onError(message: String?) {
        Log.d("Error",message)
    }
    override fun onPostClicked(movie: Unmain) {
    //
    }
}