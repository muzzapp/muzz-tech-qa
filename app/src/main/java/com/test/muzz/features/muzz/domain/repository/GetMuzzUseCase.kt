package com.test.muzz.features.muzz.domain.repository

import com.test.muzz.features.muzz.data.repository.MuzzRepository
import com.test.muzz.features.muzz.domain.model.MuzzItemsModelMapper
import com.test.muzz.features.muzz.domain.model.MuzzModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMuzzUseCase
@Inject
constructor(
    private val muzzRepository: MuzzRepository,
    private val muzzItemsModelMapper: MuzzItemsModelMapper,
) {
    operator fun invoke(): Flow<List<MuzzModel>> = muzzRepository.getMuzz().map {
        muzzItemsModelMapper.map(it)
    }
}
