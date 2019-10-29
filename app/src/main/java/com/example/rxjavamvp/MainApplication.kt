package com.example.rxjavamvp

import android.app.Application
import com.example.rxjavamvp.di.component.DaggerGitComponent
import com.example.rxjavamvp.di.component.DaggerPresenterComponent
import com.example.rxjavamvp.util.ApplicationData

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ApplicationData.gitComponent = DaggerGitComponent.create()
        ApplicationData.presenterComponent = DaggerPresenterComponent.create()
    }


}