package com.yunuseker.socialmedia.ui.viewentity

data class MovieViewEntity(
        val id: String,
        val isLiked: Boolean,
        val likeCount: Int,
        val name: String,
        val imgUrl: String
)