package com.test.muzz.features.muzz.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.muzz.features.muzz.data.dao.MuzzDao
import com.test.muzz.features.muzz.data.model.Image
import com.test.muzz.features.muzz.data.model.Muzz

@Database(
    entities = [Muzz::class, Image::class],
    version = 1,
    exportSchema = false,
)
abstract class MuzzDatabase : RoomDatabase() {
    abstract fun muzzDao(): MuzzDao
}
