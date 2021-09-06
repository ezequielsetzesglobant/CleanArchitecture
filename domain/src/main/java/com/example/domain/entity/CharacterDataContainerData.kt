package com.example.domain.entity

import com.example.domain.utils.ConstantUtils

data class CharacterDataContainerData(
    val offset: Int = ConstantUtils.INT_DEFAULT,
    val limit: Int = ConstantUtils.INT_DEFAULT,
    val total: Int = ConstantUtils.INT_DEFAULT,
    val count: Int = ConstantUtils.INT_DEFAULT,
    val results: List<CharacterData> = emptyList()
)
