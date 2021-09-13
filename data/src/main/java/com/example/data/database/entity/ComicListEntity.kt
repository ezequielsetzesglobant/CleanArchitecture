package com.example.data.database.entity

import com.example.domain.utils.ConstantUtils
import io.realm.RealmList
import io.realm.RealmObject

open class ComicListEntity(
    var available: Int = ConstantUtils.INT_DEFAULT,
    var returned: Int = ConstantUtils.INT_DEFAULT,
    var collectionURI: String = ConstantUtils.STRING_DEFAULT,
    var items: RealmList<ComicSummaryEntity> = RealmList(),
) : RealmObject()
