package com.yunuseker.socialmedia.di

import android.app.Application
import com.yunuseker.socialmedia.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        UsecaseModule::class,
        RepositoryModule::class,
        FormatterModule::class
    )
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}