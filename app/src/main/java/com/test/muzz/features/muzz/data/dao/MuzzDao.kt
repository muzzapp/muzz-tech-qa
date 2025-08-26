package com.test.muzz.features.muzz.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.test.muzz.features.muzz.data.model.MuzzWithImages
import kotlinx.coroutines.flow.Flow

@Dao
interface MuzzDao {
    @Transaction
    @Query("SELECT * FROM muzz")
    fun getMuzzWithImages(): Flow<List<MuzzWithImages>>
}
