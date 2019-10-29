package com.example.rxjavamvp.presenter

import com.example.rxjavamvp.model.RepoResponse
import com.example.rxjavamvp.model.UserResponse
import io.reactivex.Observable

interface PresenterContract {
    interface GitRepoPresenter {
        fun getRepositories(): Observable<List<RepoResponse>>
        fun setRepoView(repoView: GitRepoView)
    }

    interface GitUserPresenter {
        fun getUser(): Observable<UserResponse>
        fun setUserView(userView: GitUserView)
    }

    interface GitRepoView{
        fun callFailed()
    }

    interface GitUserView{
        fun callFailed()
    }
}