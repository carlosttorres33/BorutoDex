package com.carlostorres.borutodex.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.presentation.details.DetailsViewModel
import com.carlostorres.borutodex.ui.details.components.DetailsContent

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val state = viewModel.state

    DetailsContent(
        navController = navController,
        selectedHero = state.selectedHero
    )

}