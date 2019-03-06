package com.yunuseker.socialmedia.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.yunuseker.socialmedia.base.BaseViewModel
import com.yunuseker.socialmedia.ui.viewentity.ProfileViewEntity
import com.yunuseker.socialmedia.usecase.UserUsecase
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
class VMProfileAct @Inject constructor(private val userUsecase: UserUsecase) : BaseViewModel() {
    var isLoading=MutableLiveData<Boolean>()
    var profileData = MutableLiveData<ProfileViewEntity>()

    fun getProfileData() {
        isLoading.postValue(true)
        val disposable = userUsecase.getMyProfile()
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    isLoading.postValue(false)
                    profileData.postValue(it)
                },
                {
                    isLoading.postValue(false)
                    handleError(it)
                })

        compositeDisposable.add(disposable)
    }
}