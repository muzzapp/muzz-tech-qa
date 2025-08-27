package com.test.muzz.features.muzz.data.model

import kotlinx.coroutines.delay

class FakeProfileRepository : ProfileRepository {

    // Deterministic list for automation (no randomness)
    private val profiles = listOf(
        Profile("1", "Ava", "Age: 21", "https://picsum.photos/seed/ava/600/800"),
        Profile("2", "Liam","Age: 30", "https://picsum.photos/seed/liam/600/800"),
        Profile("3", "Maya","Age: 27", "https://picsum.photos/seed/maya/600/800"),
        Profile("4", "Noah","Age: 24", "https://picsum.photos/seed/noah/600/800"),
        Profile("5", "Zara","Age: 22", "https://picsum.photos/seed/zara/600/800"),
    )

    override suspend fun getProfiles(): List<Profile> {
        // Tiny delay so candidates can practice idling/waits if they want.
        delay(1500)
        return profiles
    }
}
