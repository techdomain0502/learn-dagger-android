package com.android.learndagger.common.dependnecyinjection.presentation

import com.android.learndagger.screens.questiondetails.QuestionDetailsActivity
import com.android.learndagger.screens.questionslist.QuestionsListFragment
import com.android.learndagger.screens.viewmodel.ViewModelActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [UiModule::class,QuestionModule::class,ViewModelsModule::class])
interface PresentationComponent {
    
   fun inject(questionDetailsActivity: QuestionDetailsActivity)
   fun inject(questionsListFragment: QuestionsListFragment)
   fun inject(viewModelActivity: ViewModelActivity)

}