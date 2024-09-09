package com.carlostorres.borutodex.ui.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.carlostorres.borutodex.data.model.OnBoardingPage
import com.carlostorres.borutodex.ui.theme.PAGING_INDICATOR_SPACING
import com.carlostorres.borutodex.ui.theme.PAGING_INDICATOR_WIDTH
import com.carlostorres.borutodex.ui.theme.activeIndicatorColor
import com.carlostorres.borutodex.ui.theme.inactiveIndicatorColor
import com.carlostorres.borutodex.ui.theme.welcomeScreenBkgColor
import com.carlostorres.borutodex.ui.welcome.components.FinishButton
import com.carlostorres.borutodex.ui.welcome.components.PagerContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController,
) {

    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.welcomeScreenBkgColor)
    ) {

        HorizontalPager(
            modifier = Modifier
                .weight(10f),
            state = pagerState,
            count = pages.size,
            verticalAlignment = Alignment.Top
        ) { actualPage ->

            PagerContent(onBoardingPage = pages[actualPage])

        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activeIndicatorColor,
            inactiveColor = MaterialTheme.colors.inactiveIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING,
        )

        FinishButton(
            modifier = Modifier
                .weight(1f),
            pagerState = pagerState
        ) {
            
        }

    }
}