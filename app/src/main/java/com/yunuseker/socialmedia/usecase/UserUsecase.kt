package com.yunuseker.socialmedia.usecase

import com.yunuseker.socialmedia.base.BaseUsecase
import com.yunuseker.socialmedia.data.dto.UserDto
import com.yunuseker.socialmedia.data.repository.UserRepository
import com.yunuseker.socialmedia.ui.viewentity.FollowerViewEntity
import com.yunuseker.socialmedia.ui.viewentity.MovieViewEntity
import com.yunuseker.socialmedia.ui.viewentity.ProfileViewEntity
import io.reactivex.Observable
import io.reactivex.functions.Function3
import java.util.function.BiFunction
import javax.inject.Inject

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
class UserUsecase @Inject constructor(private val userRepository: UserRepository) : BaseUsecase() {

    fun getMyProfile(): Observable<ProfileViewEntity> {

        return Observable.zip(userRepository.getMember(), getFollowers(), getMovies(),
            Function3<UserDto, MutableList<FollowerViewEntity>, MutableList<MovieViewEntity>, ProfileViewEntity> { userDto, followerList, movieList ->

                ProfileViewEntity(
                    userDto.username,
                    userDto.profileBackgroundPictureUrl,
                    userDto.profilePictureUrl,
                    followerList,
                    movieList
                )
            })
    }

    /**
     * normalde follower için ayrı bir usecase olarak kullanılır.
     */
    fun getFollowers(): Observable<MutableList<FollowerViewEntity>> {
        return userRepository.getFollowers()
            .flatMapIterable { it }
            .map {
                return@map FollowerViewEntity(it.profilePictureUrl)
            }
            .toList()
            .toObservable()
    }


    /**
     * normalde movies için ayrı bir usecase olarak kullanılır.
     */
    fun getMovies(): Observable<MutableList<MovieViewEntity>> {
        return userRepository.getMovieList()
            .flatMapIterable { it }
            .map {
                return@map MovieViewEntity(it.id!!, it.isLiked!!, it.likeCount!!, it.name!!, it.profilePictureUrl!!)
            }
            .toList()
            .toObservable()
    }

}