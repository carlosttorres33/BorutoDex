package com.carlostorres.borutodex.ui.welcome.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.carlostorres.borutodex.ui.theme.EXTRA_LARGE_PADDING
import com.carlostorres.borutodex.ui.theme.buttonBkgColor
import com.carlostorres.borutodex.ui.theme.titleColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit,
    ) {

    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {

        AnimatedVisibility(
            enter = slideInHorizontally (
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 200)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis = 200)
            ),
            visible = pagerState.currentPage == 2
        ) {

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { onClick() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonBkgColor,
                    contentColor = Color.White
                )
            ) {

                Text(
                    text = "Finish",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

            }

        }
    }
}