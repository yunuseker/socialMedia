package com.yunuseker.socialmedia.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
@Module
class AppModule{

    @Provides
    @Singleton
    fun provideContext(application: Application):Context{
        return application.applicationContext
    }
}