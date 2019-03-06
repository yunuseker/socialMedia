package com.yunuseker.socialmedia.data.dto

import com.google.gson.annotations.SerializedName

data class FollowerResponseModel(
    @SerializedName("ItemCount")
    val itemCount: Int,
    @SerializedName("Items")
    val followerList: ArrayList<FollowerDto>
)