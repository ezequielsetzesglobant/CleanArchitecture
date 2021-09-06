package com.example.data.response

import com.example.domain.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class CharacterDataWrapperResponse(
    @SerializedName("code")
    val code: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("status")
    val status: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("copyright")
    val copyright: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("attributionText")
    val attributionText: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("attributionHTML")
    val attributionHTML: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("data")
    val data: CharacterDataContainerResponse = CharacterDataContainerResponse(),
    @SerializedName("etag")
    val etag: String = ConstantUtils.STRING_DEFAULT
)
