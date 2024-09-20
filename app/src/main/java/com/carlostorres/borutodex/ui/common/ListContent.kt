package com.carlostorres.borutodex.ui.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.carlostorres.borutodex.data.model.Hero
import com.carlostorres.borutodex.ui.home.components.ShimmerEffect
import com.carlostorres.borutodex.ui.theme.MEDIUM_PADDING

@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {
    
    val result = handlePagingResult(heroes = heroes)

    if (result){
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

}

@Composable
fun handlePagingResult(
    heroes: LazyPagingItems<Hero>
) : Boolean {

    heroes.apply {

        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when{
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }
            error != null -> {
                EmptyScreen(error = error)
                false
            }
            heroes.itemCount < 1 -> {
                EmptyScreen()
                false
            } else -> true
        }
    }

}