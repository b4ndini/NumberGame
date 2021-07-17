package com.lfelipe.numbergame.api

import com.lfelipe.numbergame.model.RandomNumber
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomNumberApi {

    @GET("rand")
    suspend fun number(
        @Query("min") min : Int = 1,
        @Query("max") max : Int = 300,
    ): Response<RandomNumber>


}