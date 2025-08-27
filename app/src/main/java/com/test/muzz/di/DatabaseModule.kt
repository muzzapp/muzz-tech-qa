package com.test.muzz.di

import android.app.Application
import androidx.room.Room
import com.test.muzz.features.login.data.dao.UsersDao
import com.test.muzz.features.login.data.db.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUsersDatabase(app: Application): UsersDatabase = Room
        .databaseBuilder(app, UsersDatabase::class.java, "users.db")
        .createFromAsset("users.db")
        .build()

    @Provides
    @Singleton
    fun provideUsersDao(database: UsersDatabase): UsersDao = database.usersDao()
}
