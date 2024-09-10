package com.carlostorres.borutodex.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.carlostorres.borutodex.ui.home.components.HomeTopBar

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            HomeTopBar {

            }
        }
    ) { paddingValues ->

    }

}