package com.example.rxjavamvp.di.component

import com.example.rxjavamvp.di.module.GitModule
import com.example.rxjavamvp.presenter.GitRepoPresenter
import com.example.rxjavamvp.presenter.GitUserPresenter
import dagger.Component

@Component(modules = [GitModule::class])
interface GitComponent {
    fun inject(gitRepoPresenter: GitRepoPresenter)
    fun inject(gitUserPresenter: GitUserPresenter)
}