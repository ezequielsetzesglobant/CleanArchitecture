package com.example.data.response

import com.example.domain.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class ComicSummaryResponse(
    @SerializedName("resourceURI")
    val resourceURI: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("name")
    val name: String = ConstantUtils.STRING_DEFAULT,
)
