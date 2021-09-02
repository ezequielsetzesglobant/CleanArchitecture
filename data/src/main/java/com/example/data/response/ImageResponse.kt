package com.example.data.response

import com.example.data.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("path")
    val path: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("extension")
    val extension: String = ConstantUtils.STRING_DEFAULT,
)
