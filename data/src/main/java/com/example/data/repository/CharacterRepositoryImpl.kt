package com.example.data.repository

import com.example.data.BuildConfig
import com.example.data.api.CharacterApi
import com.example.data.mapper.transform
import com.example.data.service.CharacterRequestGenerator
import com.example.domain.entity.CharacterDataWrapperData
import com.example.domain.repository.CharacterRepository
import com.example.domain.utils.Result

class CharacterRepositoryImpl : CharacterRepository {

    private val characterRequestGenerator = CharacterRequestGenerator()

    override fun getInformationApi(): Result<CharacterDataWrapperData> {
        try {
            val response = characterRequestGenerator.generateRequest(CharacterApi::class.java)
                .getResponseCharacter(TS, BuildConfig.API_KEY, BuildConfig.HASH).execute()
            if (response.isSuccessful) {
                response.body()?.transform()?.let { return Result.Success(it) }
            }
            return Result.Failure(Exception(response.message()))
        } catch (e: Exception) {
            return Result.Failure(Exception(EXCEPTION_MESSAGE))
        }
    }

    companion object {
        private const val TS: String = "1"
        private const val EXCEPTION_MESSAGE: String = "Request error"
    }
}
