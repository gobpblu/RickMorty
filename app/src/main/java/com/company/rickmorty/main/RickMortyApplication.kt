package com.company.rickmorty.main

import android.app.Application
import timber.log.Timber

class RickMortyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}