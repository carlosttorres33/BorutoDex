package com.carlostorres.borutodex.ui.splash

import android.content.res.Configuration
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.carlostorres.borutodex.R
import com.carlostorres.borutodex.presentation.splash.SplashViewModel
import com.carlostorres.borutodex.ui.navigation.ScreenRoutes
import com.carlostorres.borutodex.ui.theme.Purple500
import com.carlostorres.borutodex.ui.theme.Purple700

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val onBoardingCompleted by viewModel.onBoardingCompleted.collectAsState()

    val rotate = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        rotate.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navController.popBackStack()
        if (onBoardingCompleted) {
            navController.navigate(ScreenRoutes.Home.route)
        } else {
            navController.navigate(ScreenRoutes.Welcome.route)
        }
    }

    Splash(rotate = rotate.value)

}

@Composable
fun Splash(
    rotate : Float
) {

    if (isSystemInDarkTheme()) {

        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier
                    .rotate(degrees = rotate),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo)
            )

        }

    } else {

        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(Purple700, Purple500)
                    )
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier
                    .rotate(degrees = rotate),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo)
            )

        }
    }
}

@Composable
@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun SplashScreenPreview() {
    Splash(rotate = 0f)
}