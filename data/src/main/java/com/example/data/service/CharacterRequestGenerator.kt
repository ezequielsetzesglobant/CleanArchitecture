package com.example.data.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterRequestGenerator {

    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()

    fun <S> generateRequest(classAPI: Class<S>): S =
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(classAPI)

    companion object {
        private const val URL_BASE = "https://gateway.marvel.com/"
    }
}
