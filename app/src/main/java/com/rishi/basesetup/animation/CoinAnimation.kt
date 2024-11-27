package com.rishi.basesetup.animation

import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer


// Quarter calculation

fun determineQuarter(degree: Float): Int {
    val normalizedDegree = (degree + 360) % 360
    return when {
        normalizedDegree <= 90f -> 1
        normalizedDegree <= 180f -> 2
        normalizedDegree <= 270f -> 3
        else -> 4
    }
}

//  jump animation

fun jumpAnimation(duration: Int, jumpTarget: Float) = keyframes {
    durationMillis = duration
    0f at 0
    jumpTarget at (duration * 0.3f).toInt()
    0f at duration
}

//Reflected view

@Composable
fun BoxScope.ReflectVertically(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .matchParentSize()
            .graphicsLayer { rotationX = 180f },
        content = content
    )
}