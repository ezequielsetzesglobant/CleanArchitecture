package com.example.domain.repository

import com.example.domain.entity.CharacterDataWrapperEntity
import com.example.domain.utils.Result

interface CharacterRepository {

    fun getInformationApi(): Result<CharacterDataWrapperEntity>
}
