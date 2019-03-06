package com.yunuseker.socialmedia.di

import com.yunuseker.socialmedia.ui.ProfileAct
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
@Module
abstract class ActivityModule{

    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    internal abstract fun contributeProfileAct(): ProfileAct
}