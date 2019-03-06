package com.yunuseker.socialmedia.data.api

import com.yunuseker.socialmedia.data.dto.BaseResponseModel
import com.yunuseker.socialmedia.data.dto.FollowerResponseModel
import com.yunuseker.socialmedia.data.dto.MovieResponseModel
import com.yunuseker.socialmedia.data.dto.UserDto
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
interface Api{
    @GET("member")
    fun getMember():Observable<BaseResponseModel<UserDto>>

    @GET("Followers")
    fun getFollowers():Observable<BaseResponseModel<FollowerResponseModel>>

    @GET("movies")
    fun getMovies():Observable<BaseResponseModel<MovieResponseModel>>
}