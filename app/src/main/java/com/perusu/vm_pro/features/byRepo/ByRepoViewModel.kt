package com.perusu.vm_pro.features.byRepo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perusu.vm_pro.data.model.ResultOf
import com.perusu.vm_pro.data.model.User
import com.perusu.vm_pro.data.remote.IUserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ByRepoViewModel(private val userRepo: IUserRepo) : ViewModel() {

    var obUserList = MutableLiveData<ResultOf<List<User>>>()

    fun fetchUserList() {
        obUserList.value = ResultOf.Progress(true)
        obUserList.value = ResultOf.Progress(true)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                delay(2000)
            }
            obUserList.value = userRepo.getUserListOf()
            obUserList.value = ResultOf.Progress(false)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ByRepoViewModel", "onCleared: ")
    }

}