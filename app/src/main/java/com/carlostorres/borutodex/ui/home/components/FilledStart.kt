package com.carlostorres.borutodex.ui.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostorres.borutodex.ui.theme.StartColor
import okhttp3.internal.wait

@Composable
fun FilledStart(
    modifier: Modifier = Modifier,
    startPath: Path,
    startPathBounds: Rect,
    scaleFactor: Float = 2f
) {

    Canvas(
        modifier = modifier
            .size(24.dp)
    ) {

        val canvasSize = this.size

        scale(scale = scaleFactor) {

            val pathWith = startPathBounds.width
            val pathHeight = startPathBounds.height
            val left = (canvasSize.width / 2f) - (pathWith / 1.7f)
            val top = (canvasSize.height / 2f) - (pathHeight / 1.7f)

            translate(
                left = left,
                top = top
            ) {

                drawPath(
                    path = startPath,
                    color = StartColor
                )

            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun FSP() {
    RatingWidget(rating = 1.0)
}