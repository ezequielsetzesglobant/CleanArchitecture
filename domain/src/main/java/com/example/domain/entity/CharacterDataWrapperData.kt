package com.example.domain.entity

import com.example.domain.utils.ConstantUtils

data class CharacterDataWrapperData(
    val code: Int = ConstantUtils.INT_DEFAULT,
    val status: String = ConstantUtils.STRING_DEFAULT,
    val copyright: String = ConstantUtils.STRING_DEFAULT,
    val attributionText: String = ConstantUtils.STRING_DEFAULT,
    val attributionHTML: String = ConstantUtils.STRING_DEFAULT,
    val data: CharacterDataContainerData = CharacterDataContainerData(),
    val etag: String = ConstantUtils.STRING_DEFAULT
)
