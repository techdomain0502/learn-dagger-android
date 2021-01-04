package com.android.learndagger.screens.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.learndagger.R
import com.android.learndagger.screens.common.ScreensNavigator
import com.android.learndagger.screens.common.activities.BaseActivity
import com.android.learndagger.screens.common.toolbar.MyToolbar
import javax.inject.Inject

class ViewModelActivity:BaseActivity() {

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    private lateinit var toolbar: MyToolbar



    lateinit var viewModel: MyViewModel

    @Inject
    lateinit var myviewmodelFactory: MyViewModel.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_view_model)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            screensNavigator.navigateBack()
        }

        viewModel = ViewModelProvider(this,myviewmodelFactory).get(MyViewModel::class.java)
        Log.d("sachin","view model hashcode = "+viewModel.hashCode())

        viewModel.data.observe(this, Observer {
            Toast.makeText(this,"fetched ${it.size} question",Toast.LENGTH_SHORT).show()
        })

    }

  companion object{
      fun start(context: Context){
          val intent = Intent(context,ViewModelActivity::class.java)
          context.startActivity(intent)
      }
  }

}