package com.carlostorres.borutodex.ui.common

import android.content.res.Configuration
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import com.carlostorres.borutodex.R
import com.carlostorres.borutodex.ui.theme.DarkGray
import com.carlostorres.borutodex.ui.theme.LightGray
import com.carlostorres.borutodex.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.carlostorres.borutodex.ui.theme.SMALL_PADDING
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error : LoadState.Error
) {

    val message by remember {
        mutableStateOf(parseErrorMessage(error = error))
    }

    val icon by remember {
        mutableStateOf(R.drawable.network_error)
    }

    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) ContentAlpha.disabled else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(true) {
        startAnimation = true
    }

    EmptyContent(alphaAnim = alphaAnim, icon = icon, message = message)

}

@Composable
fun EmptyContent(
    alphaAnim : Float,
    icon : Int,
    message : String
) {

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            modifier = Modifier
                .size(NETWORK_ERROR_ICON_HEIGHT)
                .alpha(alpha = alphaAnim),
            painter = painterResource(id = icon),
            contentDescription = "Error Icon",
            tint = if (isSystemInDarkTheme()) LightGray else DarkGray
        )

        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING)
                .alpha(alpha = alphaAnim),
            text = message,
            color = if (isSystemInDarkTheme()) LightGray else DarkGray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )

    }
    
}

fun parseErrorMessage(error : LoadState.Error) : String {
    return when (error.error) {
        is SocketTimeoutException -> {
            "Server Unavailable"
        }
        is ConnectException -> {
            "Internet Unavailable"
        }
        else -> {
            "Unknown Error"
        }
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ESP() {
    EmptyContent(alphaAnim = 1f, icon = R.drawable.network_error, message = "Internet Unavailable")
}