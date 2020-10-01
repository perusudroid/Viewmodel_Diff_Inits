package com.perusu.vm_pro.data.remote

import com.perusu.vm_pro.data.model.ResultOf
import com.perusu.vm_pro.data.model.User
import com.perusu.vm_pro.data.model.UserDataSource

class RepoUser(val dataSource: UserDataSource) : IUserRepo {

    override fun getUserListOf(): ResultOf<List<User>> = dataSource.dummyUserListOf


}