package com.example.yt_masterand

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.yt_masterand.nav.SetupNavGraph
import com.example.yt_masterand.ui.theme.YT_MasterAndTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YT_MasterAndTheme {
                navController = rememberNavController()

                SetupNavGraph(navController = navController)
            }
        }
    }
}