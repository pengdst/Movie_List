package com.pengdst.movielist.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pengdst.movielist.R
import com.pengdst.movielist.adapters.MovieAdapter
import com.pengdst.movielist.presentation.mvvm.MainView
import com.pengdst.movielist.presentation.mvvm.MainViewModel
import com.pengdst.movielist.presentation.mvvm.MainViewState
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject lateinit var viewModel: MainViewModel

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viwModel: MainView by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        ).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.state.observe(this, Observer { state->
            when(state){
                is MainViewState.loading -> pg_movie.visibility = View.VISIBLE
                is MainViewState.Success -> {
                    pg_movie.visibility = View.GONE
                    rv_movies.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
                    rv_movies.layoutManager = LinearLayoutManager(this@MainActivity)
                    rv_movies.adapter = MovieAdapter(state.response.results)
                }
                is MainViewState.Error -> {
                    pg_movie.visibility = View.GONE
                    Log.e(MainActivity::class.java.simpleName, "${state.t.printStackTrace()}")
                }
            }
        })
        viewModel.discoverMovie()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
