package com.example.rxjavamvp.di.component

import com.example.rxjavamvp.di.module.PresenterModule
import com.example.rxjavamvp.view.MainActivity
import dagger.Component
import javax.inject.Inject

@Component(modules = [PresenterModule::class])
interface PresenterComponent {
    fun inject(mainActivity: MainActivity)
    //TODO: FRAGMENT
}