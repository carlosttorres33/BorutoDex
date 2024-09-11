package com.carlostorres.borutodex.ui.home.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlostorres.borutodex.ui.theme.StartColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Composable
fun FilledStart(
    modifier: Modifier = Modifier,
    startPath: Path,
    startPathBounds: Rect,
    scaleFactor: Float
) {

    Canvas(
        modifier = modifier
            .size(24.dp)
    ) {

        val canvasSize = size

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

@Composable
fun HalfFilledStart(
    modifier: Modifier = Modifier,
    startPath: Path,
    startPathBounds: Rect,
    scaleFactor: Float
) {

    Canvas(
        modifier = modifier
            .size(24.dp)
    ) {

        val canvasSize = size

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
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
                clipPath(path = startPath) {
                    drawRect(
                        color = StartColor,
                        size = Size(
                            width = startPathBounds.maxDimension / 1.7f,
                            height = startPathBounds.maxDimension * scaleFactor
                        )
                    )
                }

            }

        }
    }

}

@Composable
fun EmptyStart(
    modifier: Modifier = Modifier,
    startPath: Path,
    startPathBounds: Rect,
    scaleFactor: Float
) {

    Canvas(
        modifier = modifier
            .size(24.dp)
    ) {

        val canvasSize = size

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
                    color = Color.LightGray.copy(alpha = 0.5f)
                )

            }

        }
    }

}

@Composable
fun calculateStarts(rating: Double): Map<String, Int> {

    val maxStarts by remember {
        mutableStateOf(5)
    }
    var filledStarts by remember {
        mutableStateOf(0)
    }
    var halfFilledStarts by remember {
        mutableStateOf(0)
    }
    var emptyStarts by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = rating) {

        val (firstNumber, lastNumber) = rating.toString()
            .split(".").map { it.toInt() }

        if (firstNumber in 0..5 && lastNumber in 0..9) {
            filledStarts = firstNumber
            if (lastNumber in 1..5) {
                halfFilledStarts++
            }
            if (lastNumber in 6..9) {
                filledStarts++
            }
            if (firstNumber == 5 && lastNumber > 0) {
                emptyStarts = 5
                filledStarts = 0
                halfFilledStarts = 0
            }
        } else {
            Log.d("RatyingWidget", "Invalid rating number")
        }

    }

    emptyStarts = maxStarts - (filledStarts + halfFilledStarts)

    return mapOf(
        "filledStarts" to filledStarts,
        "halfFilledStarts" to halfFilledStarts,
        "emptyStarts" to emptyStarts
    )

}

@Preview(showBackground = true)
@Composable
private fun FSP() {
    RatingWidget(rating = 1.0)
}