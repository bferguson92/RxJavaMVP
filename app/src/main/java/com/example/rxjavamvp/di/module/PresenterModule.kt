package com.example.rxjavamvp.di.module

import com.example.rxjavamvp.presenter.GitRepoPresenter
import com.example.rxjavamvp.presenter.GitUserPresenter
import com.example.rxjavamvp.presenter.PresenterContract
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesRepoPresenter(): PresenterContract.GitRepoPresenter {
        return GitRepoPresenter()
    }

    @Provides
    fun providesUserPresenter(): PresenterContract.GitUserPresenter {
        return GitUserPresenter()
    }
}