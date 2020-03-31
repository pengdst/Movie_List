package com.pengdst.movielist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pengdst.movielist.R
import com.pengdst.movielist.datas.models.Movie


class MovieAdapter(var movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.movie_item,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int = movies.count()

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            with(itemView){
                val title = findViewById<TextView>(R.id.tv_title)
                val overview = findViewById<TextView>(R.id.tv_overview)

                title.text = movie.title
                overview.text = movie.overview
            }
        }
    }
}