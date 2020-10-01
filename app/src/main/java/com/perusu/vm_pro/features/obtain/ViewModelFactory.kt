package com.perusu.vm_pro.features.obtain

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.perusu.vm_pro.data.model.UserDataSource
import com.perusu.vm_pro.data.remote.IUserRepo
import com.perusu.vm_pro.data.remote.RepoUser

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repo: IUserRepo) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(ObExViewModel::class.java) -> ObExViewModel(repo)
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance() =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                    RepoUser(UserDataSource())
                ).also { INSTANCE = it }
            }

        fun destroyInstance() {
            INSTANCE = null
        }
    }


}
