package com.example.hw5

import android.app.Application
import com.example.hw5.di.appModule
import com.example.hw5.di.dataModule
import com.example.hw5.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule,dataModule, networkModule)
        }
    }
}