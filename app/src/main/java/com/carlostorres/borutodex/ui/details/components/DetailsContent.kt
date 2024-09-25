package com.carlostorres.borutodex.ui.details.components

import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.ui.theme.MIN_SHEET_HEIGHT

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedHero: Hero?
) {

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Expanded)
    )

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = MIN_SHEET_HEIGHT,
        sheetContent = {
            selectedHero?.let { BottomSheetContent(selectedHero = it) }
        }
    ) {

    }

}