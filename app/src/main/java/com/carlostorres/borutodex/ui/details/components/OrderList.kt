package com.carlostorres.borutodex.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.carlostorres.borutodex.ui.theme.SMALL_PADDING

@Composable
fun OrderList(
    modifier : Modifier = Modifier,
    title : String,
    items : List<String>,
    textColor : Color,
) {

    Column(
        modifier = modifier
    ){

        Text(
            modifier = Modifier.padding(bottom = SMALL_PADDING),
            text = title,
            color = textColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold
        )

        items.forEachIndexed { index, item ->

            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = "${index+1}. $item",
                color = textColor,
                fontSize = MaterialTheme.typography.body1.fontSize,
            )

        }

    }

}