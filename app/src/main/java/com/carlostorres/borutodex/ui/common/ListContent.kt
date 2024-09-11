package com.carlostorres.borutodex.ui.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.ui.theme.MEDIUM_PADDING

@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {

    Log.d("ListContent", heroes.loadState.toString())

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(all = MEDIUM_PADDING),
        verticalArrangement = Arrangement.spacedBy(MEDIUM_PADDING)
    ) {

        items(heroes.itemCount) { index ->

            heroes[index].let { hero ->
                HeroItem(
                    hero = hero!!,
                    navController = navController
                )
            }

        }

    }

}