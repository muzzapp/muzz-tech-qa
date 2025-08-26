package com.test.muzz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.muzz.features.login.domain.view.LoginScreen
import com.test.muzz.features.muzz.domain.view.MuzzScreen
import com.test.muzz.ui.MuzzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuzzTheme {
                MuzzAppUi()
            }
        }
    }
}

@Composable
fun MuzzAppUi() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(onLoginSuccess = { navController.navigate("muzz") })
        }
        composable("muzz") {
            MuzzScreen()
        }
    }
}
