package com.carlostorres.borutodex.ui.home.components

import android.content.res.Configuration
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostorres.borutodex.ui.theme.ABOUT_PLACEHOLDER_HEIGHT
import com.carlostorres.borutodex.ui.theme.HERO_ITEM_HEIGHT
import com.carlostorres.borutodex.ui.theme.LARGE_PADDING
import com.carlostorres.borutodex.ui.theme.MEDIUM_PADDING
import com.carlostorres.borutodex.ui.theme.NAME_PLACEHOLDER_HEIGHT
import com.carlostorres.borutodex.ui.theme.RATING_PLACEHOLDER_HEIGHT
import com.carlostorres.borutodex.ui.theme.SMALL_PADDING
import com.carlostorres.borutodex.ui.theme.ShimmerDarkGray
import com.carlostorres.borutodex.ui.theme.ShimmerLightGray
import com.carlostorres.borutodex.ui.theme.ShimmerMediumGray

@Composable
fun AnimatedShimmerItem(){

    val transition = rememberInfiniteTransition(label = "")
    val alphaAnim by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutLinearInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )
    
    ShimmerItem(alpha = alphaAnim)

}

@Composable
fun ShimmerItem(modifier: Modifier = Modifier, alpha: Float) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(HERO_ITEM_HEIGHT),
        color = if (isSystemInDarkTheme()) Color.Black else ShimmerLightGray,
        shape = RoundedCornerShape(size = LARGE_PADDING)
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {

            Surface(
                modifier = Modifier
                    .alpha(alpha)
                    .fillMaxWidth(0.5f)
                    .height(NAME_PLACEHOLDER_HEIGHT),
                color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                shape = RoundedCornerShape(SMALL_PADDING)
            ) {}

            Spacer(modifier = Modifier.height(MEDIUM_PADDING))

            repeat(3) {

                Surface(
                    modifier = Modifier
                        .alpha(alpha)
                        .fillMaxWidth()
                        .height(ABOUT_PLACEHOLDER_HEIGHT),
                    color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                    shape = RoundedCornerShape(SMALL_PADDING)
                ) {}

                Spacer(modifier = Modifier.height(SMALL_PADDING))

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                repeat(5){

                    Surface(
                        modifier = Modifier
                            .alpha(alpha)
                            .size(RATING_PLACEHOLDER_HEIGHT),
                        color = if (isSystemInDarkTheme()) ShimmerDarkGray else ShimmerMediumGray,
                        shape = RoundedCornerShape(SMALL_PADDING)
                    ) {}

                    Spacer(modifier = Modifier.width(SMALL_PADDING))

                }

            }

        }

    }

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SIP() {
    AnimatedShimmerItem()
}

@Preview()
@Composable
private fun SIPL() {

    AnimatedShimmerItem()
}