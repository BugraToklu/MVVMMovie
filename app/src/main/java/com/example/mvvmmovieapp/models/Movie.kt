package com.example.mvvmmovieapp.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("start_date")
    val startDate: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("network")
    val network: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("image_thumbnail_path")
    val thumbnail: String
)