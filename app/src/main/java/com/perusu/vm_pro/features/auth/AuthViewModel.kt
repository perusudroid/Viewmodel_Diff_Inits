package com.perusu.vm_pro.features.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perusu.vm_pro.data.model.ResultOf
import com.perusu.vm_pro.data.remote.IUserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel(val iUserRepo: IUserRepo) : ViewModel() {

    var obLogin = MutableLiveData<ResultOf<Boolean>>()
    var obRegister = MutableLiveData<ResultOf<Boolean>>()
    var obForgot = MutableLiveData<Boolean>()

    fun doLogin() {
        viewModelScope.launch {
            obLogin.value = ResultOf.Progress(true)
            withContext(Dispatchers.IO) {
                delay(1000)
            }
            obLogin.value = ResultOf.Success(true)
            obLogin.value = ResultOf.Progress(false)
        }
    }

    fun doRegister() {
        viewModelScope.launch {
            obRegister.value = ResultOf.Progress(true)
            withContext(Dispatchers.IO) {
                delay(1000)
            }
            obRegister.value = ResultOf.Success(true)
            obRegister.value = ResultOf.Progress(false)
        }
    }

    fun doForgot() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                delay(1000)
            }
            obForgot.value = true
        }
    }

}