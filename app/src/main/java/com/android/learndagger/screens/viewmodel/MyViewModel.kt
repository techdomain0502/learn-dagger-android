package com.android.learndagger.screens.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.learndagger.questions.FetchQuestionsUseCase
import com.android.learndagger.questions.Question
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(
        private val fetchQuestionsUseCase: FetchQuestionsUseCase
):ViewModel() {
    private val _data = MutableLiveData<List<Question>>()
    val data:LiveData<List<Question>> = _data

    private val TAG = MyViewModel::class.simpleName
   init {
         viewModelScope.launch {
             val result = fetchQuestionsUseCase.fetchLatestQuestions()
             if(result is FetchQuestionsUseCase.Result.Success){
                 _data.value = result.questions
             }else{
                 Log.d(TAG,"failure in fetching questions in viewmodel")
             }
         }
   }


}