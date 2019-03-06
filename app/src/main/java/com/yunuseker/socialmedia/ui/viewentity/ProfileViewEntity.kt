package com.yunuseker.socialmedia.ui.viewentity

data class ProfileViewEntity(
        val name:String,
        val bgUrlPath:String,
        val imgUrlPath:String,
        val followerList:MutableList<FollowerViewEntity>,
        val movieList:MutableList<MovieViewEntity>
)