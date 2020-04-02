package com.pengdst.movielist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pengdst.movielist.R
import com.pengdst.movielist.databinding.MovieItemBinding
import com.pengdst.movielist.datas.models.Movie
import com.pengdst.movielist.presentation.mvvm.MainAdapterViewModel


class MovieAdapter(var movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = movies.count()

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = MainAdapterViewModel(movies[holder.adapterPosition])
            executePendingBindings()
        }
    }

    inner class MovieViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)
}