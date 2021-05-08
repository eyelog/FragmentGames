package ru.eyelog.fragmentgames.fragments.firstfragment

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor() : ViewModel(), LifecycleObserver {

    val sample00LiveData: LiveData<String> get() = _sample00LiveData
    private val _sample00LiveData = MediatorLiveData<String>()

    val sample01LiveData: LiveData<String> get() = _sample01LiveData
    private val _sample01LiveData = MediatorLiveData<String>()

    val sample02LiveData: LiveData<String> get() = _sample02LiveData
    private val _sample02LiveData = MediatorLiveData<String>()

    val sample03LiveData: LiveData<String> get() = _sample03LiveData
    private val _sample03LiveData = MediatorLiveData<String>()

    val buttonStatusLiveData: LiveData<String> get() = _buttonStatusLiveData
    private val _buttonStatusLiveData = MediatorLiveData<String>()

    private var fragmentCounter = -1
    private var fragmentCursor = -1

    private var countingEngine: Flowable<Long> = Flowable.interval(1L, TimeUnit.SECONDS)
        .doOnNext {
            fragmentCounter++
            if (fragmentCursor < 3) fragmentCursor++
            else fragmentCursor = 0
        }
    private var disposable: Disposable? = null

    fun handleCounting() {
        if (disposable == null || disposable?.isDisposed == true) {
            disposable = countingEngine
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    setData(fragmentCounter.toString())
                }
            _buttonStatusLiveData.value = "Counting started"
        } else {
            disposable?.dispose()
            _buttonStatusLiveData.value = "Counting stopped"
        }
    }

    private fun setData(data: String) {
        when (fragmentCursor) {
            0 -> _sample00LiveData.value = data
            1 -> _sample01LiveData.value = data
            2 -> _sample02LiveData.value = data
            3 -> _sample03LiveData.value = data
            else -> _sample00LiveData.value = data
        }
    }
}
