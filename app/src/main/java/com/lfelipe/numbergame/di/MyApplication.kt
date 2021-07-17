package com.lfelipe.numbergame.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MyApplication)
            modules(mainModule)
        }
    }

}