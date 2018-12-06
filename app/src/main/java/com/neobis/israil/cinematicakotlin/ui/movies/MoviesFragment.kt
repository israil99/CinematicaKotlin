package com.neobis.israil.cinematicakotlin.ui.movies


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neobis.israil.cinematicakotlin.R
import com.neobis.israil.cinematicakotlin.model.movies.Result
import com.neobis.israil.cinematicakotlin.ui.movie.MoviesPresenter
import kotlinx.android.synthetic.main.fragment_movies.*
import android.support.v7.widget.GridLayoutManager



class MoviesFragment : Fragment(),MoviesContract.View, MoviesAdapter.Listener {

    private var presenter: MoviesContract.Presenter? = null
    private var adapter: MoviesAdapter? = null
    private var list: MutableList<Any> = ArrayList()
    private var isSelectedElements = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies,container,false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        recycler_view.layoutManager = GridLayoutManager(activity,3)

        adapter = MoviesAdapter(list, this)
        recycler_view.adapter = adapter
        presenter = MoviesPresenter(this)

        presenter?.loadMovies()

        swipeRefresh.setOnRefreshListener {

            presenter?.loadMovies()

        }



    }



    override fun onMoviesResponse(result: Result) {
        //
   }

    override fun showProgress() {
        swipeRefresh?.isRefreshing = true
    }

    override fun hideProgress() {
        swipeRefresh?.isRefreshing = false
        isSelectedElements = false
    }

    override fun onSuccess(result: MutableList<Result>) {
        this.list.addAll(result)
        adapter?.setPostList(this.list)
        recycler_view.adapter = adapter    }

    override fun onError(message: String?) {
        Log.d("Error",message)
    }

    override fun onPostClicked(movie: Result) {

    }

}