package com.carlostorres.borutodex.ui.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.carlostorres.borutodex.R
import com.carlostorres.borutodex.data.model.OnBoardingPage
import com.carlostorres.borutodex.ui.theme.EXTRA_LARGE_PADDING
import com.carlostorres.borutodex.ui.theme.SMALL_PADDING
import com.carlostorres.borutodex.ui.theme.descriptionColor
import com.carlostorres.borutodex.ui.theme.titleColor

@Composable
fun PagerContent(
    onBoardingPage: OnBoardingPage
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(
                R.string.on_boarding_image
            )
        )

        Text(
            text = onBoardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = onBoardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontStyle = MaterialTheme.typography.subtitle1.fontStyle,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING)
        )

    }

}