package com.example.data.response

import com.example.data.utils.ConstantUtils
import com.google.gson.annotations.SerializedName

data class StoryListResponse(
    @SerializedName("available")
    val available: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("returned")
    val returned: Int = ConstantUtils.INT_DEFAULT,
    @SerializedName("collectionURI")
    val collectionURI: String = ConstantUtils.STRING_DEFAULT,
    @SerializedName("items")
    val items: List<StorySummaryResponse> = emptyList(),
)
