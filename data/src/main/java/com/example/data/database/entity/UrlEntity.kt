package com.example.data.database.entity

import com.example.domain.utils.ConstantUtils
import io.realm.RealmObject

open class UrlEntity(
    var type: String = ConstantUtils.STRING_DEFAULT,
    var url: String = ConstantUtils.STRING_DEFAULT,
) : RealmObject()
