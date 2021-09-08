package com.example.domain.entity

import com.example.domain.utils.ConstantUtils

data class ImageData(
    val path: String = ConstantUtils.STRING_DEFAULT,
    val extension: String = ConstantUtils.STRING_DEFAULT,
) : java.io.Serializable
