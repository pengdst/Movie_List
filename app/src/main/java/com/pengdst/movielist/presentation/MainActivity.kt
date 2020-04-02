package com.pengdst.movielist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pengdst.movielist.R
import com.pengdst.movielist.adapters.MovieAdapter
import com.pengdst.movielist.databinding.ActivityMainBinding
import com.pengdst.movielist.datas.models.Movie
import com.pengdst.movielist.presentation.mvvm.MainViewModel
import com.pengdst.movielist.presentation.mvvm.MainViewModelCallback
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainViewModelCallback {
    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main)
            .apply { viewModel = this@MainActivity.viewModel }
            .also { viewModel.discoverMovie() }
    }

    override fun onSuccess(result: List<Movie>) {
        binding.rvMovies.addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
        binding.rvMovies.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvMovies.adapter = MovieAdapter(result)
    }

    override fun onFailed(error: Throwable) {
        Log.e(MainActivity::class.java.simpleName, "${error.printStackTrace()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDetach()
    }
}
