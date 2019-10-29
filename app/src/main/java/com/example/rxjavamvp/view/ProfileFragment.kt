package com.example.rxjavamvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.rxjavamvp.R
import com.example.rxjavamvp.presenter.PresenterContract
import com.example.rxjavamvp.util.ApplicationData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.image.*
import javax.inject.Inject

class ProfileFragment : Fragment(), PresenterContract.GitUserView {

    @Inject
    lateinit var gitUserPresenter: PresenterContract.GitUserPresenter

    override fun callFailed() {
        //TODO
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.image, container, false)
    }

    val compositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ApplicationData.presenterComponent?.inject(this)
        gitUserPresenter.setUserView(this)

        compositeDisposable.add(gitUserPresenter.getUser().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                Glide.with(this).load(it.avatarUrl).into(image_view_avatar)
            }, {}))
    }
}