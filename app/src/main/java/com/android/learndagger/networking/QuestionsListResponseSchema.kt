package com.android.learndagger.networking

import com.google.gson.annotations.SerializedName
import com.android.learndagger.questions.Question

data class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)