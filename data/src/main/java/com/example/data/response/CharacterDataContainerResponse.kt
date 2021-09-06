package com.example.data.response

import com.example.domain.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class CharacterDataContainerResponse(
    @SerializedName("offset")
    val offset: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("limit")
    val limit: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("total")
    val total: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("count")
    val count: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("results")
    val results: List<CharacterResponse> = emptyList()
)
