package com.test.muzz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.muzz.features.login.domain.view.LoginScreen
import com.test.muzz.features.muzz.domain.view.ProfilesScreen
import com.test.muzz.ui.MuzzTheme
import dagger.hilt.android.AndroidEntryPoint

private object Routes {
    const val Login = "login"
    const val Profiles = "profiles"
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MuzzTheme { MuzzAppUi() } }
    }
}

@Composable
fun MuzzAppUi() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Login) {
        composable(Routes.Login) {
            LoginScreen(
                onLoginSuccess = {
                    // Go to Profiles and remove Login from back stack
                    navController.navigate(Routes.Profiles) {
                        popUpTo(Routes.Login) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(Routes.Profiles) {
            ProfilesScreen(
                onLogout = {
                    navController.navigate(Routes.Login) {
                        popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
