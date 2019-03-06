package com.yunuseker.socialmedia.data.repository
import com.yunuseker.socialmedia.base.BaseRepository
import com.yunuseker.socialmedia.data.api.Api
import com.yunuseker.socialmedia.data.dto.FollowerDto
import com.yunuseker.socialmedia.data.dto.MovieDto
import com.yunuseker.socialmedia.data.dto.UserDto
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
class UserRepository @Inject constructor(private val api: Api):BaseRepository(){

    fun getMember():Observable<UserDto>{
        return api.getMember().map { it.data }
    }

    /**
     * normalde bu iki iş followes ve movie repository de yapılır
     * örnek proje olduğu için böyle de yapılabilir.
     */
    fun getFollowers():Observable<ArrayList<FollowerDto>>{
        return api.getFollowers().map { it.data?.followerList }
    }

    fun getMovieList():Observable<ArrayList<MovieDto>>{
        return api.getMovies().map { it.data?.movieList }
    }
}