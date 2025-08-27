package com.test.muzz.di

import com.test.muzz.features.login.data.repository.UsersRepository
import com.test.muzz.features.login.domain.repository.LoginInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object InteractorModule {
    @Provides
    fun provideLoginInteractor(usersRepository: UsersRepository): LoginInteractor = LoginInteractor(usersRepository)
}
