package com.android.learndagger.common.dependnecyinjection.presentation

import androidx.lifecycle.ViewModel
import com.android.learndagger.screens.viewmodel.MyViewModel
import com.android.learndagger.screens.viewmodel.MyViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewModel(vm1:MyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel2::class)
    abstract fun myViewModel2(vm2:MyViewModel2): ViewModel

}