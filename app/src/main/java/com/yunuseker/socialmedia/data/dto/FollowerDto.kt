package com.yunuseker.socialmedia.data.dto

import com.google.gson.annotations.SerializedName

data class FollowerDto(
    @SerializedName("profilePictureUrl")
    val profilePictureUrl: String,
    @SerializedName("userId")
    val userId: String
)