package com.test.muzz.features.login.data.repository

import com.test.muzz.features.login.data.dao.UsersDao
import com.test.muzz.features.login.data.model.User
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class UsersRepository
@Inject
constructor(
    private val usersDao: UsersDao,
) {
    fun getUser(userName: String) = usersDao.getUser(userName)
}
