package com.android.learndagger.screens.questiondetails

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.learndagger.R
import com.android.learndagger.networking.ImageLoader
import com.android.learndagger.questions.QuestionWithBody
import com.android.learndagger.screens.common.toolbar.MyToolbar
import com.android.learndagger.screens.common.viewsmvc.BaseViewMvc

class QuestionDetailsViewMvc(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        private val imageLoader: ImageLoader
): BaseViewMvc<QuestionDetailsViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.layout_question_details
) {

    interface Listener {
        fun onBackClicked()
    }

    private val toolbar: MyToolbar
    private val swipeRefresh: SwipeRefreshLayout
    private val txtQuestionBody: TextView
    private val imageView:ImageView
    private val userTextView:TextView

    init {
        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackClicked()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false

        imageView = findViewById(R.id.userImage)
        userTextView = findViewById(R.id.userName)
    }

    fun bindQuestionBody(questionBody: QuestionWithBody) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtQuestionBody.text = Html.fromHtml(questionBody.body, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(questionBody.body)
        }
        userTextView.text = questionBody.owner.user_name
        imageLoader.loadImage(imageView,questionBody.owner.profile_image)

    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing) {
            swipeRefresh.isRefreshing = false
        }
    }
}