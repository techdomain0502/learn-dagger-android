package com.android.learndagger.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass


class ViewModelFactory @Inject
    constructor(
            private val providers:Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory{

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            val provider = providers[modelClass]
            return provider?.get() as T ?: throw RuntimeException("no provider present to get view model "+modelClass)
        }

    }