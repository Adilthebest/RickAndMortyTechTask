package com.example.rickandmorty

import android.app.Application
import kg.example.mangalib.di.appModule
import kg.example.mangalib.di.dataModule
import kg.example.mangalib.di.domainModule
import com.example.rickandmorty.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule, networkModule))
        }
    }
}