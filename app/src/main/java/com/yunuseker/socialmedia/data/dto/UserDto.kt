package com.yunuseker.socialmedia.data.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("profileBackgroundPictureUrl")
    val profileBackgroundPictureUrl: String,
    @SerializedName("profilePictureUrl")
    val profilePictureUrl: String,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("username")
    val username: String
)