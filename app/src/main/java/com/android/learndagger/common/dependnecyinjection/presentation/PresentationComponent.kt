package com.android.learndagger.common.dependnecyinjection.presentation

import com.android.learndagger.screens.questiondetails.QuestionDetailsActivity
import com.android.learndagger.screens.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [UiModule::class,QuestionModule::class])
interface PresentationComponent {
    
   fun inject(questionDetailsActivity: QuestionDetailsActivity)
   fun inject(questionsListFragment: QuestionsListFragment)

}