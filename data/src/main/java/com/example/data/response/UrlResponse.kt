package com.example.data.response

import com.example.data.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class UrlResponse(
    @SerializedName("type")
    val type: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("url")
    val url: String = ConstantUtils.STRING_DEFAULT,
)
