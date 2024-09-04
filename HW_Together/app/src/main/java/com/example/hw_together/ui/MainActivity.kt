package com.example.hw_together.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.hw_together.ui.components.ADD_TAB
import com.example.hw_together.ui.components.CHAT_TAB
import com.example.hw_together.ui.components.CustomBottomBar
import com.example.hw_together.ui.components.FAVORITES_TAB
import com.example.hw_together.ui.components.MAIN_TAB
import com.example.hw_together.ui.components.PROFILE_TAB
import com.example.hw_together.ui.navigation.ADD_NOTE_SCREEN_ROUTE
import com.example.hw_together.ui.navigation.AUTHORIZATION_REGISTER_SCREEN_ROUTE
import com.example.hw_together.ui.navigation.MAIN_SCREEN_ROUTE
import com.example.hw_together.ui.navigation.MAIN_TAB_HOST_ROUTE
import com.example.hw_together.ui.navigation.NavHost
import com.example.hw_together.ui.navigation.navigateToAddNoteScreen
import com.example.hw_together.ui.navigation.navigateToMainScreen
import com.example.hw_together.ui.navigation.navigateToMainTab
import com.example.hw_together.ui.theme.HW_TogetherTheme
import dagger.hilt.android.AndroidEntryPoint

private const val TOKEN_KEY = "token_key"
private const val PREFS_KEY = "prefs_key"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        val myPrefs = getSharedPreferences(PREFS_KEY, MODE_PRIVATE)
        val token = myPrefs.getString(TOKEN_KEY, "").toString()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //requestWindowFeature(FEATURE_NO_TITLE)
        setContent {
            val isBottomBarVisible = remember { mutableStateOf(false) }
            val navController = rememberNavController()
            HW_TogetherTheme {
                val startDestination = if (token.isEmpty()) {
                    AUTHORIZATION_REGISTER_SCREEN_ROUTE
                } else {
                    MAIN_TAB_HOST_ROUTE
                }
                Scaffold(
                    containerColor = Color.Transparent,
                    bottomBar = {
                        AnimatedVisibility(
                            visible = isBottomBarVisible.value,
                            enter = fadeIn() + expandVertically(),
                            exit = fadeOut() + shrinkVertically(),
                        ) {
                            CustomBottomBar { tab ->
                                when (tab) {
                                    MAIN_TAB -> navController.navigateToMainTab()
                                    FAVORITES_TAB -> {}
                                    ADD_TAB -> navController.navigateToAddNoteScreen()
                                    CHAT_TAB -> {}
                                    PROFILE_TAB -> {}
                                }
                            }
                        }
                    }
                )
                { paddingValue ->
                    NavHost(
                        navController = navController,
                        bottomBarHeight = paddingValue.calculateBottomPadding(),
                        setBottomBarVisibility = { isBottomBarVisible.value = it },
                        startDestination = startDestination
                    )
                }
            }
        }
    }
}