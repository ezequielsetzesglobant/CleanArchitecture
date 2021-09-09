package com.example.domain.entity

import com.example.domain.utils.ConstantUtils

data class ComicSummaryData(
    val resourceURI: String = ConstantUtils.STRING_DEFAULT,
    val name: String = ConstantUtils.STRING_DEFAULT,
) : java.io.Serializable
