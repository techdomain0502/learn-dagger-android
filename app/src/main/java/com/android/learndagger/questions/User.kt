package com.android.learndagger.questions

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("profile_image") val profile_image:String,
        @SerializedName("display_name") val user_name:String
)
