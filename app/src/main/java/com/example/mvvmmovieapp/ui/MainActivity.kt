package com.example.mvvmmovieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmmovieapp.R
import com.example.mvvmmovieapp.adapters.MovieAdapter
import com.example.mvvmmovieapp.databinding.ActivityMainBinding
import com.example.mvvmmovieapp.models.Movie
import com.example.mvvmmovieapp.viewmodels.MovieViewModel

class MainActivity : AppCompatActivity() {

    val viewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    val activityMainBinding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main) }
    private var currentPage = 1
    private var totalAvailablePages = 1
    lateinit var movieAdapter: MovieAdapter
    val movie = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        doInitialization()
    }

    private fun doInitialization(){
        activityMainBinding.movieRecyclerView.setHasFixedSize(true)
        movieAdapter = MovieAdapter(movie, this)
        activityMainBinding.movieRecyclerView.adapter = movieAdapter
        activityMainBinding.movieRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!activityMainBinding.movieRecyclerView.canScrollVertically(1)){
                    if (currentPage <= totalAvailablePages){
                        currentPage += 1
                        getMostPopularMovie()
                    }
                }
            }
        })
        getMostPopularMovie()
    }

    private fun getMostPopularMovie(){
        toggleLoading()
        viewModel.getMostPopularMovie(currentPage).observe(this){ movieResponse ->
            toggleLoading()
            totalAvailablePages = movieResponse.pages
            val oldCount = movie.size
            movie.addAll(movieResponse.tvShows)
            movieAdapter.notifyItemRangeInserted(oldCount, movie.size)

        }
    }

    private fun toggleLoading(){
        if (currentPage == 1){
            activityMainBinding.isLoading =
                !(activityMainBinding.isLoading != null && activityMainBinding.isLoading)
        } else {
            activityMainBinding.isLoadingMore =
                !(activityMainBinding.isLoadingMore != null && activityMainBinding.isLoadingMore)
        }
    }
}