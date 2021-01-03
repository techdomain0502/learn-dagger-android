package com.android.learndagger.screens.common

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.learndagger.common.dependnecyinjection.activity.ActivityScope
import com.android.learndagger.screens.questiondetails.QuestionDetailsActivity
import com.android.learndagger.screens.viewmodel.ViewModelActivity
import javax.inject.Inject

@ActivityScope
class ScreensNavigator @Inject constructor(private val activity: AppCompatActivity) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    fun toViewModelActivity(){
        Log.d("sachin","onview model clicked")
        ViewModelActivity.start(activity)
    }
}