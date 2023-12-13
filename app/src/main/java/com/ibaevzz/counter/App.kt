package com.ibaevzz.counter

import android.app.Application
import com.ibaevzz.counter.db.CounterRepository

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        CounterRepository.init(this)
    }
}