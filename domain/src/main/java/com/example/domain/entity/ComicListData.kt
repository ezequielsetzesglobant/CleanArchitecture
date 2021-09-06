package com.example.domain.entity

import com.example.domain.utils.ConstantUtils

data class ComicListData(
    val available: Int = ConstantUtils.INT_DEFAULT,
    val returned: Int = ConstantUtils.INT_DEFAULT,
    val collectionURI: String = ConstantUtils.STRING_DEFAULT,
    val items: List<ComicSummaryData> = emptyList(),
)
