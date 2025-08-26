package com.test.muzz.features.muzz.domain.repository

import com.test.muzz.features.muzz.domain.model.MuzzModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import timber.log.Timber

class MuzzInteractor
@Inject
constructor(
    private val getMuzzUseCase: GetMuzzUseCase,
) {
    fun getMuzz(): Flow<MuzzResult> = getMuzzUseCase()
        .map<List<MuzzModel>, MuzzResult> { MuzzResult.Muzz(it) }
        .onStart { emit(MuzzResult.Loading) }
        .catch { throwable ->
            Timber.e(throwable)
            emit(MuzzResult.Error)
        }
}
