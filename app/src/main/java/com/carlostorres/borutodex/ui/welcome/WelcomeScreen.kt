package com.carlostorres.borutodex.ui.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.carlostorres.borutodex.data.model.OnBoardingPage
import com.carlostorres.borutodex.ui.theme.welcomeScreenBkgColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
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
            state = pagerState,
            count = pages.size,
            verticalAlignment = Alignment.Top
        ) { actualPage ->

            PagerContent(onBoardingPage = pages[actualPage])
            
        }
    }
}

@Composable
fun PagerContent(
    onBoardingPage: OnBoardingPage
) {


    
}