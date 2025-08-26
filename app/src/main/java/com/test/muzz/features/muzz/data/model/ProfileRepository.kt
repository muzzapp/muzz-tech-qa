package com.test.muzz.features.muzz.data.model

interface ProfileRepository {
    suspend fun getProfiles(): List<Profile>
}
