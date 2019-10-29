package com.example.rxjavamvp.presenter

import com.example.rxjavamvp.factory.GitFactory
import com.example.rxjavamvp.model.UserResponse
import com.example.rxjavamvp.util.ApplicationData
import io.reactivex.Observable
import javax.inject.Inject

class GitUserPresenter : PresenterContract.GitUserPresenter {

    @Inject
    lateinit var gitFactory : GitFactory

    private lateinit var userView: PresenterContract.GitUserView

    init {
        ApplicationData.gitComponent?.inject(this)
    }

    override fun setUserView(userView: PresenterContract.GitUserView) {
        this.userView = userView
    }

    override fun getUser(): Observable<UserResponse> {
        return gitFactory.getUser("bferguson92")
    }
}
