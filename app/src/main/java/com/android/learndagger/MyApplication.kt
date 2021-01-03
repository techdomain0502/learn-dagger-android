package com.android.learndagger

import android.app.Application
import com.android.learndagger.common.dependnecyinjection.application.AppComponent
import com.android.learndagger.common.dependnecyinjection.application.AppModule
import com.android.learndagger.common.dependnecyinjection.application.DaggerAppComponent

class MyApplication: Application() {

     lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        super.onCreate()
    }

}