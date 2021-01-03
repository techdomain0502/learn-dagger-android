package com.android.learndagger.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.android.learndagger.MyApplication
import com.android.learndagger.common.dependnecyinjection.activity.ActivityModule
import com.android.learndagger.common.dependnecyinjection.presentation.QuestionModule
import com.android.learndagger.common.dependnecyinjection.presentation.UiModule

open class BaseActivity: AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
       //DaggerActivityComponent.builder().appComponent(appComponent).activityModule(ActivityModule(this)).build()
       appComponent.newActivityComponent(ActivityModule(this))
    }


    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(UiModule(), QuestionModule())
    // DaggerPresentationComponent.builder().activityComponent(activityComponent).presentationModule(PresentationModule()).build()
    }

    protected val injector get() = presentationComponent
}