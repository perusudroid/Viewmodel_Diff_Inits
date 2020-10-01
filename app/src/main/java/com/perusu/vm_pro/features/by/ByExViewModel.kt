package com.perusu.vm_pro.features.by

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ByExViewModel : ViewModel() {

    val obMessage = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        Log.d("ByExViewModel", "onCleared: ")
    }


}