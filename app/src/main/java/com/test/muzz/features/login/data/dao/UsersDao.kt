package com.test.muzz.features.login.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.test.muzz.features.login.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Query("SELECT * FROM user WHERE userName = :userName")
    fun getUser(userName: String): Flow<User?>

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>
}
