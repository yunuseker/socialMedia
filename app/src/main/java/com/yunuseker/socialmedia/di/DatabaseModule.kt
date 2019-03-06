package com.yunuseker.socialmedia.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
@Module(includes = arrayOf(AppModule::class))
class DatabaseModule{
    @Singleton
    @Provides
    fun providesSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("myDB", Context.MODE_PRIVATE)
    }

}