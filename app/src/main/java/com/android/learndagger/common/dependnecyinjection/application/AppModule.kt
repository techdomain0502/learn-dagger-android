package com.android.learndagger.common.dependnecyinjection.application

import android.app.Application
import android.content.Context
import androidx.annotation.UiThread
import com.android.learndagger.Constants
import com.android.learndagger.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@UiThread
class AppModule(val application: Application) {

    @Provides
    fun provide_application() = application



    @Provides
    @Named("app_context")
    fun provide_context(): Context = application.applicationContext


     private val retrofit: Retrofit by lazy {
         Retrofit.Builder()
                 .baseUrl(Constants.BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
     }


    @AppScope
    @Provides
    fun  provide_stackoverflowApi(): StackoverflowApi  {
       return retrofit.create(StackoverflowApi::class.java)
    }

}