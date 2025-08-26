package com.test.muzz.features.muzz.data.repository

import com.test.muzz.features.muzz.data.dao.MuzzDao
import com.test.muzz.features.muzz.data.model.MuzzWithImages
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class MuzzRepository
@Inject
constructor(
    private val muzzDao: MuzzDao,
) {
    fun getMuzz(): Flow<List<MuzzWithImages>> = muzzDao.getMuzzWithImages()
}
