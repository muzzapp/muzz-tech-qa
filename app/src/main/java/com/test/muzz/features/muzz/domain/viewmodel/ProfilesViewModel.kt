package com.test.muzz.features.muzz.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.muzz.features.muzz.data.model.Profile
import com.test.muzz.features.muzz.data.model.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class ProfilesUiState(
    val loading: Boolean = true,
    val profiles: List<Profile> = emptyList(),
    val index: Int = 0,
    val liked: Int = 0,
    val passed: Int = 0,
    val error: String? = null
) {
    val current: Profile? get() = profiles.getOrNull(index)
    val finished: Boolean get() = !loading && profiles.isNotEmpty() && index >= profiles.size
}

@HiltViewModel
class ProfilesViewModel @Inject constructor(
    private val repo: ProfileRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProfilesUiState())
    val state: StateFlow<ProfilesUiState> = _state

    init { load() }

    fun load() {
        _state.value = ProfilesUiState(loading = true)
        viewModelScope.launch {
            runCatching { repo.getProfiles() }
                .onSuccess { list ->
                    _state.value = _state.value.copy(
                        loading = false,
                        profiles = list,
                        index = 0,
                        liked = 0,
                        passed = 0,
                        error = null
                    )
                }
                .onFailure { e ->
                    _state.value = _state.value.copy(
                        loading = false,
                        error = e.message ?: "Unknown error"
                    )
                }
        }
    }

    fun like() {
        val s = _state.value
        if (s.current != null) {
            _state.value = s.copy(index = s.index + 1, liked = s.liked + 1)
        }
    }

    fun pass() {
        val s = _state.value
        if (s.current != null) {
            _state.value = s.copy(index = s.index + 1, passed = s.passed + 1)
        }
    }

    fun resetDeck() = load()
}
