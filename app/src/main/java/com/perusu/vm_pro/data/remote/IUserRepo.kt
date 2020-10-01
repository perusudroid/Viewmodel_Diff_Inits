package com.perusu.vm_pro.data.remote

import com.perusu.vm_pro.data.model.ResultOf
import com.perusu.vm_pro.data.model.User

interface IUserRepo {
    fun getUserListOf(): ResultOf<List<User>>
}