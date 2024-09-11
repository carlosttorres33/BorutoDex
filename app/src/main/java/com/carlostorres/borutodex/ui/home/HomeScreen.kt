package com.carlostorres.borutodex.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.carlostorres.borutodex.presentation.home.HomeViewModel
import com.carlostorres.borutodex.ui.home.components.HomeTopBar
import com.carlostorres.borutodex.ui.common.ListContent

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar {

            }
        },
        content = { paddingValues ->

            ListContent(
                modifier = Modifier.padding(paddingValues),
                heroes = allHeroes,
                navController = navController
            )

        }
    )

}