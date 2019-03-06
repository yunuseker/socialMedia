package com.yunuseker.socialmedia.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.yunuseker.socialmedia.R
import com.yunuseker.socialmedia.base.BaseActivity
import com.yunuseker.socialmedia.base.BaseRecyclerAdapter
import com.yunuseker.socialmedia.databinding.ActProfileBinding
import com.yunuseker.socialmedia.ui.viewentity.FollowerViewEntity
import com.yunuseker.socialmedia.ui.viewentity.MovieViewEntity
import com.yunuseker.socialmedia.viewmodel.VMProfileAct

class ProfileAct : BaseActivity<ActProfileBinding, VMProfileAct>() {
    override val getLayoutRes: Int = R.layout.act_profile
    override val viewModelClass: Class<VMProfileAct> = VMProfileAct::class.java
    val followersAdapter = BaseRecyclerAdapter<FollowerViewEntity>(R.layout.item_follower)
    val moviesAdapter = BaseRecyclerAdapter<MovieViewEntity>(R.layout.item_movie)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeProfileData()
        setAdapters()
        viewModel.getProfileData()
    }

    fun subscribeProfileData() {
        viewModel.profileData.observe(this, Observer {
            binding.data = it
            followersAdapter.appendData(it?.followerList)
            moviesAdapter.appendData(it?.movieList)
        })
    }

    fun setAdapters() {
        binding.rvFollowers.adapter = followersAdapter
        binding.rvMovies.adapter = moviesAdapter
    }
}
