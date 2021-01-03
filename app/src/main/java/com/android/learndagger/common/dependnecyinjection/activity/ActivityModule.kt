package com.android.learndagger.common.dependnecyinjection.activity

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule(
        val activity: AppCompatActivity

) {
    @Provides
    fun provide_activity():AppCompatActivity = activity

    @Provides
    @Named("activity_context")
    fun provide_context(): Context = activity.baseContext

    //@Provides
    //@ActivityScope
    //fun provide_screensNavigator(activity: AppCompatActivity)= ScreensNavigator(activity)


    @Provides
    fun provide_layoutInflater(activity: AppCompatActivity) = LayoutInflater.from(activity)

    @Provides
    fun provide_fragmentManager() = activity.supportFragmentManager


}