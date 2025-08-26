package com.test.muzz.features.login.domain.model

import com.test.muzz.features.login.data.model.User

sealed class LoginResult {
    data class LoginFailed(
        @LoginFailReason val failReason: Int,
    ) : LoginResult()

    data class LoginSucceed(
        val user: User,
    ) : LoginResult()

    class Idle : LoginResult()
}
