package ru.eyelog.fragmentgames.fragments.secondfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(): ViewModel() {

    val sampleLiveData: LiveData<String> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<String>()

    private var numberCounter = 0

    init {
        _sampleLiveData.value = numberCounter.toString()
    }

    fun dataPlus(){
        numberCounter++
        _sampleLiveData.value = numberCounter.toString()
    }

    fun dataMinus(){
        numberCounter--
        _sampleLiveData.value = numberCounter.toString()
    }
}
