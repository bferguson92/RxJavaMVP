package com.example.rxjavamvp.di.module

import com.example.rxjavamvp.factory.GitFactory
import dagger.Module
import dagger.Provides

@Module
class GitModule {

    @Provides
    fun providesGitFactory(): GitFactory{
        return GitFactory()
    }
}