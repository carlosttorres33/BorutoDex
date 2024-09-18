package com.carlostorres.borutodex.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.carlostorres.borutodex.ui.theme.SMALL_PADDING

@Composable
fun ShimmerEffect() {

    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {

        items(count = 2){
            AnimatedShimmerItem()
        }

    }

}