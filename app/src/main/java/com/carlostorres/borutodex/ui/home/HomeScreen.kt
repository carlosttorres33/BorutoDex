package com.carlostorres.borutodex.ui.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.carlostorres.borutodex.presentation.home.HomeViewModel
import com.carlostorres.borutodex.ui.home.components.HomeTopBar
import com.carlostorres.borutodex.ui.common.ListContent
import com.carlostorres.borutodex.ui.navigation.ScreenRoutes

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar {
                navController.navigate(ScreenRoutes.Search.route)
            }
        },
        content = { paddingValues ->

            ListContent(
                modifier = Modifier.padding(paddingValues),
                heroes = allHeroes,
                navController = navController
            )

        },
        backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    )

}