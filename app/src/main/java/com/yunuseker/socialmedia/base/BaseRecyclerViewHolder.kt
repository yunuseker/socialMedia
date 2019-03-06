package com.yunuseker.socialmedia.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.yunuseker.socialmedia.BR

/**
 * Created by yunuseker on 5.3.2019.
 * github.com/yunuseker
 * younuseker@gmail.com
 */
class BaseRecyclerViewHolder<DATA>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setData(data: DATA) {
        binding.setVariable(BR.data, data)
        binding.executePendingBindings()
    }
}
