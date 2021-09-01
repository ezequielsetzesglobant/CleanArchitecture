package com.example.data.api

import com.example.data.response.CharacterDataWrapperResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("v1/public/characters?")
    fun getResponseCharacter(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Call<CharacterDataWrapperResponse>
}
