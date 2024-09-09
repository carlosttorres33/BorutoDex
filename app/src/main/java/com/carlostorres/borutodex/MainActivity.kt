package com.carlostorres.borutodex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.carlostorres.borutodex.navigation.SetupNavGraph
import com.carlostorres.borutodex.ui.theme.BorutoDexTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoDexTheme {

                navController = rememberNavController()

                SetupNavGraph(navController = navController)

            }
        }
    }
}