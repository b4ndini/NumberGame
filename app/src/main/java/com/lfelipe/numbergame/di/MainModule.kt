package com.lfelipe.numbergame.di

import com.lfelipe.numbergame.repository.MainRepository
import com.lfelipe.numbergame.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single {
        MainRepository()
    }

    viewModel {
        MainViewModel(
            get()
        )
    }

}
