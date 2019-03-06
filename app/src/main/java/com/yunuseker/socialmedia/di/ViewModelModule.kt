package com.yunuseker.socialmedia.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.yunuseker.socialmedia.viewmodel.VMProfileAct
import com.yunuseker.socialmedia.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
@Module
abstract class ViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(VMProfileAct::class)
    internal abstract fun vmProfileAct(viewModel: VMProfileAct):ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory):ViewModelProvider.Factory
}