package com.example.data.database.entity

import com.example.domain.utils.ConstantUtils
import io.realm.RealmObject

open class ImageEntity(
    var path: String = ConstantUtils.STRING_DEFAULT,
    var extension: String = ConstantUtils.STRING_DEFAULT,
) : RealmObject()
