package com.example.rxjavamvp.factory

import com.example.rxjavamvp.model.RepoResponse
import com.example.rxjavamvp.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService{
    @GET("users/{user_name}")
    fun getUser(@Path("user_name") gitUserName: String): Observable<UserResponse>

    @GET("users/{user_name}/repos")
    fun getUserRepos(@Path("user_name") gitUserName: String): Observable<List<RepoResponse>>
}