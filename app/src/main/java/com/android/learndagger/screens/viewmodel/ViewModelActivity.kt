package com.android.learndagger.screens.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.learndagger.R
import com.android.learndagger.screens.common.ScreensNavigator
import com.android.learndagger.screens.common.activities.BaseActivity
import com.android.learndagger.screens.common.toolbar.MyToolbar
import javax.inject.Inject

class ViewModelActivity:BaseActivity() {

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    private lateinit var toolbar: MyToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_view_model)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            screensNavigator.navigateBack()
        }

    }

  companion object{
      fun start(context: Context){
          val intent = Intent(context,ViewModelActivity::class.java)
          context.startActivity(intent)
      }
  }

}