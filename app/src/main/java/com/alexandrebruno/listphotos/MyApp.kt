package com.alexandrebruno.listphotos

import android.app.Application
import com.alexandrebruno.listphotos.data.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)

            modules(mainModule)
        }
    }

}