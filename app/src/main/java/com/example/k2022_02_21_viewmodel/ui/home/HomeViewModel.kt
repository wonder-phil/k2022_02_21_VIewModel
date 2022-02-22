package com.example.k2022_02_21_viewmodel.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _my_score = MutableLiveData<Int>().apply {
        value = 0
    }
    fun getScore(): LiveData<Int> {
        return _my_score
    }
    fun setScore(newScore: Int) {
        _my_score.postValue(newScore)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    public fun getText() : MutableLiveData<String> {
        return _text
    }
    public fun changeText(text: String) {
        _text.setValue(text)
    }
}