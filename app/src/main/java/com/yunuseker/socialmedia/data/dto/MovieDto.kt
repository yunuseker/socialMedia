package com.yunuseker.socialmedia.data.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("Id")
    val id: String?,
    @SerializedName("createDate")
    val createDate: String?,
    @SerializedName("isLiked")
    val isLiked: Boolean?,
    @SerializedName("likeCount")
    val likeCount: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("profilePictureUrl")
    val profilePictureUrl: String?
)