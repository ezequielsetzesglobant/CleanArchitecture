package com.example.data.database

import com.example.data.database.entity.CharacterDataWrapperEntity
import com.example.data.mapper.transformEntityToData
import com.example.data.mapper.transformResponseToEntity
import com.example.data.response.CharacterDataWrapperResponse
import com.example.domain.entity.CharacterDataWrapperData
import com.example.domain.utils.Result
import io.realm.Realm

class CharacterDataBase {

    fun insertOrUpdateCharacterDataWrapperData(characterDataWrapperResponse: CharacterDataWrapperResponse) {
        Realm.getDefaultInstance().use {
            it.executeTransaction { realm ->
                realm.insertOrUpdate(characterDataWrapperResponse.transformResponseToEntity())
            }
        }
    }

    fun getCharacterDataWrapperData(): Result<CharacterDataWrapperData> {
        Realm.getDefaultInstance().use {
            val characterDataWrapperEntity = it.where(CharacterDataWrapperEntity::class.java).findFirst()
            characterDataWrapperEntity?.transformEntityToData()?.let { return Result.Success(it) }
        }
        return Result.Failure(Exception(EMPTY_DATA_BASE))
    }

    companion object {
        private const val EMPTY_DATA_BASE: String = "No information found in the database"
    }
}
