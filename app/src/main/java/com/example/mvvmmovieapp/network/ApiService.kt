package com.example.mvvmmovieapp.network

import android.telecom.Call
import com.example.mvvmmovieapp.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("most-popular")
    fun getMostPopularMovie(
        @Query("page")
        page : Int
    ) : retrofit2.Call<MovieResponse>


}