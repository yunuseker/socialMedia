package com.yunuseker.socialmedia.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.yunuseker.socialmedia.data.dto.ErrorDto
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
open class BaseViewModel : ViewModel() {
    protected val compositeDisposable = CompositeDisposable()
    var errorData = MutableLiveData<ErrorDto>()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun handleError(throwable: Throwable) {

    }
}