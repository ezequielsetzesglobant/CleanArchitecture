package com.example.domain.entity

import com.example.domain.utils.ConstantUtils

data class UrlData(
    val type: String = ConstantUtils.STRING_DEFAULT,
    val url: String = ConstantUtils.STRING_DEFAULT,
)
