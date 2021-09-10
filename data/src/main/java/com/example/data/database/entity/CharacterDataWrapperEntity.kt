package com.example.data.database.entity

import com.example.domain.utils.ConstantUtils
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CharacterDataWrapperEntity(
    var code: Int = ConstantUtils.INT_DEFAULT,
    var status: String = ConstantUtils.STRING_DEFAULT,
    var copyright: String = ConstantUtils.STRING_DEFAULT,
    var attributionText: String = ConstantUtils.STRING_DEFAULT,
    var attributionHTML: String = ConstantUtils.STRING_DEFAULT,
    var data: CharacterDataContainerEntity? = CharacterDataContainerEntity(),
    @PrimaryKey
    var etag: String = ConstantUtils.STRING_DEFAULT
) : RealmObject()
