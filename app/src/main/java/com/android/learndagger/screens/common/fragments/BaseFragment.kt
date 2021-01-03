package com.android.learndagger.screens.common.fragments

import androidx.fragment.app.Fragment
import com.android.learndagger.common.dependnecyinjection.presentation.QuestionModule
import com.android.learndagger.common.dependnecyinjection.presentation.UiModule
import com.android.learndagger.screens.common.activities.BaseActivity

open class BaseFragment: Fragment() {

    private val activityComponent get() = (requireActivity() as BaseActivity).activityComponent


    private val presentationComponent by lazy {
        //DaggerPresentationComponent.builder().activityComponent(activityComponent).presentationModule(PresentationModule()).build()
        activityComponent.newPresentationComponent(UiModule(), QuestionModule())
    }

    protected val injector get() = presentationComponent
}