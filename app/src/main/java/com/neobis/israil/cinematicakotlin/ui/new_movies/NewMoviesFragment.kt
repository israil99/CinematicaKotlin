package com.neobis.israil.cinematicakotlin.ui.new_movies

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neobis.israil.cinematicakotlin.R
import com.neobis.israil.cinematicakotlin.model.newMovies.Result
import kotlinx.android.synthetic.main.fragment_new_movies.*

class NewMoviesFragment : Fragment(),NewMoviesContract.View, NewMoviesAdapter.Listener {

    private var presenter: NewMoviesContract.Presenter? = null
    private var adapter: NewMoviesAdapter? = null
    private var list: MutableList<Any> = ArrayList()
    private var isSelectedElements = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_movies,container,false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        recycler_view2.layoutManager = GridLayoutManager(activity,3)

        adapter = NewMoviesAdapter(list, this)
        recycler_view2.adapter = adapter
        presenter = NewMoviesPresenter(this)

        presenter?.loadNewMovies()

        swipeRefresh2.setOnRefreshListener {

            presenter?.loadNewMovies()

        }
    }



    override fun onNewMoviesResponse(result: Result) {
        //
    }

    override fun showProgress() {
        swipeRefresh2?.isRefreshing = true
    }

    override fun hideProgress() {
        swipeRefresh2?.isRefreshing = false
        isSelectedElements = false
    }

    override fun onSuccess(result: List<Result>) {
        this.list.addAll(result)
        adapter?.setPostList(this.list)
        recycler_view2.adapter = adapter    }

    override fun onError(message: String?) {
        Log.d("Error",message)
    }

    override fun onPostClicked(movie: Result) {
        //ss
    }

}