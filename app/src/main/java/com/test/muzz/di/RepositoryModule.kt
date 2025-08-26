package com.test.muzz.di

import com.test.muzz.features.login.data.dao.UsersDao
import com.test.muzz.features.login.data.repository.UsersRepository
import com.test.muzz.features.muzz.data.dao.MuzzDao
import com.test.muzz.features.muzz.data.repository.MuzzRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUsersRepository(usersDao: UsersDao): UsersRepository = UsersRepository(usersDao)

    @Provides
    @Singleton
    fun provideMuzzRepository(muzzDao: MuzzDao): MuzzRepository = MuzzRepository(muzzDao)
}
