package com.example.tema4

import android.app.Application
import android.content.Context

class FrisApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        application = this

    }

    companion object{
        lateinit var application: FrisApplication

    }
}
