package com.yunuseker.socialmedia.di

import com.yunuseker.socialmedia.data.repository.UserRepository
import com.yunuseker.socialmedia.usecase.UserUsecase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
@Module(includes = arrayOf(RepositoryModule::class, FormatterModule::class))
class UsecaseModule {

    @Provides
    @Singleton
    fun provideUserUsecase(userRepository: UserRepository): UserUsecase {
        return UserUsecase(userRepository)
    }
}
