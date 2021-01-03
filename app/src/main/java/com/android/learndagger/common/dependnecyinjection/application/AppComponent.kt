package com.android.learndagger.common.dependnecyinjection.application

import com.android.learndagger.common.dependnecyinjection.activity.ActivityComponent
import com.android.learndagger.common.dependnecyinjection.activity.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule):ActivityComponent;
}