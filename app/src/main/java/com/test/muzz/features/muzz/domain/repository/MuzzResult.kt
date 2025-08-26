package com.test.muzz.features.muzz.domain.repository

import com.test.muzz.features.muzz.domain.model.MuzzModel

sealed class MuzzResult {
    object Loading : MuzzResult()

    object Error : MuzzResult()

    data class Muzz(
        val muzz: List<MuzzModel>,
    ) : MuzzResult()
}
