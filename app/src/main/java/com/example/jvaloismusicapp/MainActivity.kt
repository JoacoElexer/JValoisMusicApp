package com.example.jvaloismusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.jvaloismusicapp.routes.AlbumDetailRoute
import com.example.jvaloismusicapp.routes.HomeScreenRoute
import com.example.jvaloismusicapp.screens.AlbumDetailScreen
import com.example.jvaloismusicapp.screens.HomeScreen
import com.example.jvaloismusicapp.ui.theme.JValoisMusicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JValoisMusicAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = HomeScreenRoute){
                        composable<HomeScreenRoute> {
                            HomeScreen(
                                navController = navController,
                                pv = innerPadding
                            )
                        }
                        composable<AlbumDetailRoute> { backEntry ->
                            val args = backEntry.toRoute<AlbumDetailRoute>()
                            AlbumDetailScreen(args.id, innerPadding)
                        }
                    }
                }
            }
        }
    }
}