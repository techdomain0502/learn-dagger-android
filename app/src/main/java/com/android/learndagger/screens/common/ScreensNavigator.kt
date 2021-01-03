package com.android.learndagger.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.android.learndagger.common.dependnecyinjection.activity.ActivityScope
import com.android.learndagger.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

@ActivityScope
class ScreensNavigator @Inject constructor(private val activity: AppCompatActivity) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }
}