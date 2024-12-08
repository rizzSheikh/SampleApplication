package com.droid.sampleapplication.ui.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.droid.sampleapplication.ui.theme.SampleApplicationTheme

@Composable
fun CustomProgressBar(indicatorSize: Dp = 36.dp){
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val angle by infiniteTransition
        .animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = 600
                }
            ),
            label = ""
        )

    CircularProgressIndicator(
        progress = 0.6f,
        modifier = Modifier
            .size(indicatorSize)
            .rotate(angle)
            .border(
                4.dp,
                brush = Brush.sweepGradient(
                    listOf(
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                        MaterialTheme.colorScheme.primary
                    )
                ),
                shape = CircleShape
            ),
        strokeWidth = 0.8.dp,
        color = MaterialTheme.colorScheme.surface
    )
}

@Preview
@Composable
private fun CustomProgressBarPreview() {
    SampleApplicationTheme {
        Surface {
            CustomProgressBar()
        }
    }
}