package com.example.rxjavamvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjavamvp.R
import com.example.rxjavamvp.model.RepoResponse
import com.example.rxjavamvp.presenter.GitRepoPresenter
import com.example.rxjavamvp.presenter.GitUserPresenter
import com.example.rxjavamvp.presenter.PresenterContract
import com.example.rxjavamvp.util.ApplicationData.presenterComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import javax.inject.Inject

class MainActivity : AppCompatActivity(), PresenterContract.GitRepoView {
    override fun callFailed() {
        //TODO: Handle Error
    }

    @Inject
    lateinit var gitRepoPresenter: PresenterContract.GitRepoPresenter

    val compositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenterComponent?.inject(this)
        gitRepoPresenter.setRepoView(this)

        compositeDisposable.add(gitRepoPresenter.getRepositories().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({list->
                printMyList(list)

            }, {throwable ->

            }))
    }

    private fun printMyList(list: List<RepoResponse>) {
        val stringBuilder = StringBuilder()

        list.forEach{repoResponse ->
            stringBuilder.append("${repoResponse.name}\n")
        }

        text_view_view.text = stringBuilder.toString()
    }

}
