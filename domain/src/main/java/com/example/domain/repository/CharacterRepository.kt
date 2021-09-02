package com.example.domain.repository

import com.example.domain.entity.CharacterDataWrapperData
import com.example.domain.utils.Result

interface CharacterRepository {

    fun getInformationApi(): Result<CharacterDataWrapperData>
}
