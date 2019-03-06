package com.yunuseker.socialmedia.di

import com.google.gson.Gson
import com.yunuseker.socialmedia.BuildConfig
import com.yunuseker.socialmedia.data.api.Api
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
@Module(includes = arrayOf(AppModule::class))
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
        return okHttpBuilder.build()
    }

    @Singleton
    @Provides
    fun provideApiService(okHttpClient: OkHttpClient, gson: Gson): Api {
        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
        return retrofitBuilder.build().create(Api::class.java)
    }
}