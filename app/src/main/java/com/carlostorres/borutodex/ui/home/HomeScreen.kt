package com.carlostorres.borutodex.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.carlostorres.borutodex.presentation.home.HomeViewModel
import com.carlostorres.borutodex.ui.home.components.HomeTopBar

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar {

            }
        }
    ) { paddingValues ->

    }

}