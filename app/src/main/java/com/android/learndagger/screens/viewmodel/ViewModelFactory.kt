package com.android.learndagger.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider


    class ViewModelFactory @Inject constructor(private val myViewModelProvider: Provider<MyViewModel>,
    private val myViewModel2Provider: Provider<MyViewModel2>
                                               ): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return when(modelClass){
                 MyViewModel::class.java ->{
                     return myViewModelProvider.get() as T
                 }
                MyViewModel2::class.java ->{
                    return myViewModel2Provider.get() as T
                }
                else ->
                    throw RuntimeException("no provider present to get view model "+modelClass)
            }
        }

    }