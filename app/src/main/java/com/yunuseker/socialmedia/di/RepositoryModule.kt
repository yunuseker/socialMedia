package com.yunuseker.socialmedia.di

import android.content.SharedPreferences
import com.yunuseker.socialmedia.data.api.Api
import com.yunuseker.socialmedia.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
@Module(includes = arrayOf(DatabaseModule::class, NetworkModule::class))
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(api: Api, sharedPreferences: SharedPreferences): UserRepository {
        return UserRepository(api)
    }


}