package com.example.mvvmmovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmmovieapp.R
import com.example.mvvmmovieapp.models.Movie
import com.example.mvvmmovieapp.databinding.ItemViewBinding
import com.example.mvvmmovieapp.listeners.MovieListener
import com.squareup.picasso.Picasso

class MovieAdapter(val movie: List<Movie>, val movieListener: MovieListener) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val movieBinding = DataBindingUtil.inflate<ItemViewBinding>(
                layoutInflater, R.layout.item_view, parent, false
            )
        return MovieViewHolder(movieBinding)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movie.get(position))
    }

    inner class MovieViewHolder(val itemViewBinding: ItemViewBinding):
        RecyclerView.ViewHolder(itemViewBinding.root){
        fun bindMovie(movie: Movie){

            itemViewBinding.movie = movie
            itemViewBinding.executePendingBindings()
            itemViewBinding.root.setOnClickListener {
                movieListener.onMovieClicked(movie)
            }
        }
    }
}