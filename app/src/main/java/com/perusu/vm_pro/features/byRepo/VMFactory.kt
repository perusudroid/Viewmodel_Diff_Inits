package com.perusu.vm_pro.features.byRepo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.perusu.vm_pro.data.model.UserDataSource
import com.perusu.vm_pro.features.obtain.ViewModelFactory
import com.perusu.vm_pro.data.remote.IUserRepo
import com.perusu.vm_pro.data.remote.RepoUser

class VMFactory : ViewModelProvider.Factory {

    init {
        getInstance()
    }

    companion object {
        @Volatile
        private var INSTANCE: IUserRepo? = null

        fun getInstance() =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: RepoUser(
                    UserDataSource()
                ).also { INSTANCE = it }
            }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IUserRepo::class.java).newInstance(INSTANCE)
    }
}