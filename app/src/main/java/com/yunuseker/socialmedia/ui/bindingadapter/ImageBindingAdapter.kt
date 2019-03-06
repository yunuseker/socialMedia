package com.yunuseker.socialmedia.ui.bindingadapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yunuseker.socialmedia.R

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("loadUrl")
    fun loadUrl(view: ImageView, url: String?) {
        Glide.with(view.context).load(url ?: "").into(view)
    }

    @JvmStatic
    @BindingAdapter("loadCircleUrl")
    fun loadCircleUrl(view: ImageView, url: String?) {
        Glide.with(view.context).load(url ?: "").apply(RequestOptions().optionalCircleCrop()).into(view)
    }

    @JvmStatic
    @BindingAdapter("isLiked")
    fun isLiked(view: ImageView, isLiked: Boolean) {
        if (isLiked){
            Glide.with(view.context).load(view.context.getDrawable(R.drawable.ic_like)).into(view)
        }else{
            Glide.with(view.context).load(view.context.getDrawable(R.drawable.ic_like_empty)).into(view)
        }
    }
}
