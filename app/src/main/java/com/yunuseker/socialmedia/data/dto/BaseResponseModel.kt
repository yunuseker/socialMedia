package com.yunuseker.socialmedia.data.dto

import com.google.gson.annotations.SerializedName

class BaseResponseModel<DATA>(data: DATA) {
    @SerializedName("Result")
    var data: DATA? = data
}