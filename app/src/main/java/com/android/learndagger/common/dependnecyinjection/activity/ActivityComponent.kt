package com.android.learndagger.common.dependnecyinjection.activity

import com.android.learndagger.common.dependnecyinjection.presentation.PresentationComponent
import com.android.learndagger.common.dependnecyinjection.presentation.QuestionModule
import com.android.learndagger.common.dependnecyinjection.presentation.UiModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(uiModule: UiModule,questionModule: QuestionModule): PresentationComponent
}