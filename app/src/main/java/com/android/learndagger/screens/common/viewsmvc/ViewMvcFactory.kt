package com.android.learndagger.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.learndagger.networking.ImageLoader
import com.android.learndagger.screens.questiondetails.QuestionDetailsViewMvc
import com.android.learndagger.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(private val layoutInflater: LayoutInflater,private val imageLoader: ImageLoader) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsViewMvc(parent: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(layoutInflater, parent,imageLoader)
    }
}