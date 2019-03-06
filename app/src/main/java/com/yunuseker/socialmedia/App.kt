package com.yunuseker.socialmedia

import android.app.Activity
import android.app.Application
import com.yunuseker.socialmedia.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App:Application(),HasActivityInjector{

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        setupDagger()
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    private fun setupDagger() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}