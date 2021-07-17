package com.lfelipe.numbergame.api

import com.lfelipe.numbergame.util.Api.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val randomNumberApi = getRandomNumberApiClient().create(RandomNumberApi::class.java)

    private fun getRandomNumberApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}