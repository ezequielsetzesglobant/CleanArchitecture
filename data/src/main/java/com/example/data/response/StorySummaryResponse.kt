package com.example.data.response

import com.example.data.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class StorySummaryResponse(
    @SerializedName("resourceURI")
    val resourceURI: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("name")
    val name: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("type")
    val type: String = ConstantUtils.STRING_DEFAULT,
)
