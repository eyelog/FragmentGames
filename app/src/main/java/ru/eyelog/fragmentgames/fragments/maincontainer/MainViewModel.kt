package ru.eyelog.fragmentgames.fragments.maincontainer

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel(), LifecycleObserver {

    val numberLiveData: LiveData<Int> get() = _numberLiveData
    private val _numberLiveData = MediatorLiveData<Int>()

    private var numberCursor = 0

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate(){
        _numberLiveData.value = numberCursor
    }

    fun setNumber(number: Int){
        numberCursor = number
    }
}
