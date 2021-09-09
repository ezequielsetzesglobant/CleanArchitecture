package com.example.domain.entity

import com.example.domain.utils.ConstantUtils

data class StoryListData(
    val available: Int = ConstantUtils.INT_DEFAULT,
    val returned: Int = ConstantUtils.INT_DEFAULT,
    val collectionURI: String = ConstantUtils.STRING_DEFAULT,
    val items: List<StorySummaryData> = emptyList(),
) : java.io.Serializable
