package com.example.hw8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.hw8.ui.navigation.MAIN_SCREEN_ROUTE
import com.example.hw8.ui.navigation.NavHost
import com.example.hw8.ui.theme.HW8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            HW8Theme {
                // Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = MAIN_SCREEN_ROUTE
                )
                //  }
            }
        }
    }
}