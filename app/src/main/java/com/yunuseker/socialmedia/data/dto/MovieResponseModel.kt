package com.yunuseker.socialmedia.data.dto

import com.google.gson.annotations.SerializedName

data class MovieResponseModel(
    @SerializedName("ItemCount")
    val itemCount: Int,
    @SerializedName("Items")
    val movieList: ArrayList<MovieDto>
)