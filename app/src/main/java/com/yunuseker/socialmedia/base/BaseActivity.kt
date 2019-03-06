package com.yunuseker.socialmedia.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.yunuseker.socialmedia.BR
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var binding: DB
    protected lateinit var viewModel: VM
    abstract val getLayoutRes: Int
    abstract val viewModelClass:Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,getLayoutRes)
        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        binding.setVariable(BR.viewmodel,viewModel)

    }

}