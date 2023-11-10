package com.example.mvvmmovieapp.models

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("page")
    val page: Int,

    @SerializedName("pages")
    val pages: Int,

    @SerializedName("tv_shows")
    val tvShows: List<Movie>
        )