package com.example.data.response

import com.example.data.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class SeriesSummaryResponse(
    @SerializedName("resourceURI")
    val resourceURI: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("name")
    val name: String = ConstantUtils.STRING_DEFAULT,
)
