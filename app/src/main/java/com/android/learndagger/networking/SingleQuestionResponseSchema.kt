package com.android.learndagger.networking

import com.google.gson.annotations.SerializedName
import com.android.learndagger.questions.QuestionWithBody

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>) {
    val question: QuestionWithBody get() = questions[0]
}