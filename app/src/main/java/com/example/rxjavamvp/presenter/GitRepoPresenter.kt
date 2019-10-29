package com.example.rxjavamvp.presenter

import com.example.rxjavamvp.factory.GitFactory
import com.example.rxjavamvp.model.RepoResponse
import com.example.rxjavamvp.util.ApplicationData
import io.reactivex.Observable
import javax.inject.Inject

class GitRepoPresenter : PresenterContract.GitRepoPresenter {

    @Inject
    lateinit var gitFactory: GitFactory

    init {
        ApplicationData.gitComponent?.inject(this)
    }

    private lateinit var repoView: PresenterContract.GitRepoView

    override fun setRepoView(repoView: PresenterContract.GitRepoView) {
        this.repoView = repoView
    }

    override fun getRepositories(): Observable<List<RepoResponse>> {
        return gitFactory.getRepos("bferguson92")
    }

}