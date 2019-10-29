package com.example.rxjavamvp.factory

import com.example.rxjavamvp.model.RepoResponse
import com.example.rxjavamvp.model.UserResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GitFactory {

    val BASE_URL = "http://api.github.com/"
    var gitService: GitService

    init {
        gitService = createService(getRetroFitInstance())
    }

    private fun getRetroFitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createService(retrofit: Retrofit) : GitService {
        return retrofit.create(GitService::class.java)
    }

    fun getUser(userName: String): Observable<UserResponse> {
        return gitService.getUser(userName)
    }

    fun getRepos(userName: String): Observable<List<RepoResponse>>{
        return gitService.getUserRepos(userName)
    }
}