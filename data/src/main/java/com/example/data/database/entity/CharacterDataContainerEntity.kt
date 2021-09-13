package com.example.data.database.entity

import com.example.domain.utils.ConstantUtils
import io.realm.RealmList
import io.realm.RealmObject

open class CharacterDataContainerEntity(
    var offset: Int = ConstantUtils.INT_DEFAULT,
    var limit: Int = ConstantUtils.INT_DEFAULT,
    var total: Int = ConstantUtils.INT_DEFAULT,
    var count: Int = ConstantUtils.INT_DEFAULT,
    var results: RealmList<CharacterEntity> = RealmList()
) : RealmObject()
