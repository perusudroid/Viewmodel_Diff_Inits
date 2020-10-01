package com.perusu.vm_pro.features.flowEmit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.perusu.vm_pro.data.model.ResultOf
import com.perusu.vm_pro.data.remote.IUserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FlowEmitViewModel(private val userRepo: IUserRepo) : ViewModel() {

    val fetchUserList = liveData {
        emit(ResultOf.Progress(true))
        delay(1000)
        withContext(Dispatchers.IO) {
            emit(userRepo.getUserListOf())
        }
        emit(ResultOf.Progress(false))
    }


}