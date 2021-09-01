package com.example.data.repository

import com.example.data.BuildConfig
import com.example.data.api.CharacterApi
import com.example.data.mapper.transform
import com.example.data.service.CharacterRequestGenerator
import com.example.domain.entity.CharacterDataWrapperEntity
import com.example.domain.repository.CharacterRepository
import com.example.domain.utils.Result

class CharacterRepositoryImpl : CharacterRepository {

    private val weatherRequestGenerator = CharacterRequestGenerator()

    override fun getInformationApi(): Result<CharacterDataWrapperEntity> {
        val response = weatherRequestGenerator.generateRequest(CharacterApi::class.java)
            .getResponseCharacter(TS, BuildConfig.API_KEY, BuildConfig.HASH).execute()
        if (response.isSuccessful) {
            response.body()?.transform()?.let { return Result.Success(it) }
        }
        return Result.Failure(Exception(response.message()))
    }

    companion object {
        private const val TS: String = "1"
    }
}
