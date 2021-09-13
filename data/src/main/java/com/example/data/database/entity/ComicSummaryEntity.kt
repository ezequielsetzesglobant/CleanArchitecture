package com.example.data.database.entity

import com.example.domain.utils.ConstantUtils
import io.realm.RealmObject

open class ComicSummaryEntity(
    var resourceURI: String = ConstantUtils.STRING_DEFAULT,
    var name: String = ConstantUtils.STRING_DEFAULT,
) : RealmObject()
