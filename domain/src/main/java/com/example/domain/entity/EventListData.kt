package com.example.domain.entity

import com.example.domain.utils.ConstantUtils

data class EventListData(
    val available: Int = ConstantUtils.INT_DEFAULT,
    val returned: Int = ConstantUtils.INT_DEFAULT,
    val collectionURI: String = ConstantUtils.STRING_DEFAULT,
    val items: List<EventSummaryData> = emptyList(),
)
