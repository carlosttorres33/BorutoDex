package com.carlostorres.borutodex.ui.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.carlostorres.borutodex.presentation.search.SearchViewModel
import com.carlostorres.borutodex.ui.common.ListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavHostController,
    viewModel: SearchViewModel = hiltViewModel(),
) {

    val searchQuery = viewModel.searchQuery.value
    val heroes = viewModel.searchHeroes.collectAsLazyPagingItems()

    val focusRequester =
        remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchQuery,
                onTextChange = {
                    viewModel.updateSearchQuery(it)
                },
                onSearchClicked = {
                    viewModel.searchHeroes(it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                },
                focusRequester = focusRequester
            )
        }
    ) { padding ->

        ListContent(
            modifier = Modifier.padding(padding),
            heroes = heroes,
            navController = navController
        )

    }

}