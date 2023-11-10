package com.example.mvvmmovieapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmmovieapp.models.MovieResponse
import com.example.mvvmmovieapp.network.ApiClient
import com.example.mvvmmovieapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MovieRepository {

    private val apiService = ApiClient.getRetrofit().create(ApiService::class.java)

     fun getMostPopularMovie(page: Int) : LiveData<MovieResponse> {
        val data = MutableLiveData<MovieResponse>()
        apiService.getMostPopularMovie(page).enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                data.value = null
            }

        })
            return data
    }



}