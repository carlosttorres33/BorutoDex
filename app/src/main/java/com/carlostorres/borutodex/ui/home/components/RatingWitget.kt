package com.carlostorres.borutodex.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.carlostorres.borutodex.R
import com.carlostorres.borutodex.ui.theme.EXTRA_SMALL_PADDING

@Composable
fun RatingWidget(
    modifier: Modifier = Modifier,
    rating: Double,
    scaleFactor: Float = 3f,
    spaceBetween: Dp = EXTRA_SMALL_PADDING
) {
    
    val result = calculateStarts(rating = rating)

    val startPathString = stringResource(id = R.string.start_path)

    val startPath = remember {
        PathParser().parsePathString(pathData = startPathString).toPath()
    }

    val startPathBounds = remember {
        startPath.getBounds()
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {

        result["filledStarts"]?.let {
            repeat(it) {
                FilledStart(
                    startPath = startPath,
                    startPathBounds = startPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }

        result["halfFilledStarts"]?.let {
            repeat(it) {
                HalfFilledStart(
                    startPath = startPath,
                    startPathBounds = startPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }

        result["emptyStarts"]?.let {
            repeat(it) {
                EmptyStart(
                    startPath = startPath,
                    startPathBounds = startPathBounds,
                    scaleFactor = scaleFactor
                )
            }
        }

    }

}