package com.test.muzz.features.muzz.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.muzz.features.muzz.domain.repository.MuzzInteractor
import com.test.muzz.features.muzz.domain.repository.MuzzResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MuzzViewModel
@Inject
constructor(
    private val muzzInteractor: MuzzInteractor,
) : ViewModel() {
    private val _muzzState = MutableStateFlow<MuzzResult>(MuzzResult.Loading)
    val muzzState: StateFlow<MuzzResult> = _muzzState

    init {
        getMuzz()
    }

    private fun getMuzz() {
        muzzInteractor
            .getMuzz()
            .onEach {
                _muzzState.value = it
            }.launchIn(viewModelScope)
    }
}
