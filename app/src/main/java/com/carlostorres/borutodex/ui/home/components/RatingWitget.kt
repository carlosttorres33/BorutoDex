package com.carlostorres.borutodex.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import com.carlostorres.borutodex.R

@Composable
fun RatingWidget(
    modifier: Modifier = Modifier,
    rating: Double,
    scaleFactor: Float = 3f
) {

    val startPathString = stringResource(id = R.string.start_path)

    val startPath = remember {
        PathParser().parsePathString(pathData = startPathString).toPath()
    }

    val startPathBounds = remember {
        startPath.getBounds()
    }

    Column {

        FilledStart(
            startPath = startPath,
            startPathBounds = startPathBounds,
            scaleFactor = scaleFactor
        )

        HalfFilledStart(
            startPath = startPath,
            startPathBounds = startPathBounds,
            scaleFactor = scaleFactor
        )

        EmptyStart(startPath = startPath, startPathBounds = startPathBounds, scaleFactor = scaleFactor)

    }


}