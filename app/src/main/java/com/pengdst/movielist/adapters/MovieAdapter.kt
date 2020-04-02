package com.pengdst.movielist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pengdst.movielist.R
import com.pengdst.movielist.datas.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*


class MovieAdapter(var movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.movie_item,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int = movies.count()

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie){
            with(itemView){
                tv_title.text = movie.title
                tv_overview.text = movie.overview
            }

        }
    }
}