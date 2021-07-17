package com.lfelipe.numbergame.repository

import com.lfelipe.numbergame.api.ApiService
import com.lfelipe.numbergame.api.ResponseApi
import java.lang.Exception

class MainRepository {

    suspend fun getRandomNumber(): ResponseApi {
        return try{
            val response = ApiService.randomNumberApi.number()

            if(response.isSuccessful){
                ResponseApi.Success(response.body())
            }
            else{
                ResponseApi.Error(response.code().toString())
            }
        }catch (exception: Exception){
            ResponseApi.Error("ERRO CARREGAR")
        }
    }

}