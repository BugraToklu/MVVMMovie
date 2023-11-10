package com.example.mvvmmovieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmmovieapp.models.MovieResponse
import com.example.mvvmmovieapp.repository.MovieRepository

class MovieViewModel : ViewModel() {

     val movieRepository = MovieRepository()

     fun getMostPopularMovie(page : Int) : LiveData<MovieResponse> = movieRepository.getMostPopularMovie(page)

}