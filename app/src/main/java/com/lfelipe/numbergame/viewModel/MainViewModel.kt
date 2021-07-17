package com.lfelipe.numbergame.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lfelipe.numbergame.api.ResponseApi
import com.lfelipe.numbergame.model.RandomNumber
import com.lfelipe.numbergame.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel(){


    var randomNumberLiveData: MutableLiveData<RandomNumber> = MutableLiveData()
    val errorMsgLiveData: MutableLiveData<String> = MutableLiveData()

    fun getRandomNumber(){
        viewModelScope.launch {
            when(val response = repository.getRandomNumber()){
                is ResponseApi.Success -> {
                    randomNumberLiveData.value  = response.data as RandomNumber?
                }
                is ResponseApi.Error -> {
                    errorMsgLiveData.value = response.msg
                }
            }
        }
    }


}