package com.pengdst.movielist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pengdst.movielist.R
import com.pengdst.movielist.adapters.MovieAdapter
import com.pengdst.movielist.datas.models.Movie
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getDiscoverMovie()
    }

    override fun onSuccess(result: List<Movie>) {
        rv_movies.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
        rv_movies.layoutManager = LinearLayoutManager(this@MainActivity)
        rv_movies.adapter = MovieAdapter(result)
    }

    override fun showLoading() {
        pg_movie.visibility = View.VISIBLE
    }

    override fun onFailed(error: Throwable) {
        Log.e(MainActivity::class.java.simpleName, "${error.printStackTrace()}")
    }

    override fun hideLoading() {
        pg_movie.visibility = View.GONE
    }

}
