package org.christophertwo.portfolio.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun TextAlpha(text: String): String {
    val initiallyVisible = false
    val blockFadeInDurationMillis = 500
    val typingSpeedPerCharMillis = 75L
    val startDelayMillis = 0L
    var displayedText by remember(text, initiallyVisible) {
        mutableStateOf(if (initiallyVisible) text else "")
    }
    val alpha = remember(text, initiallyVisible) {
        Animatable(if (initiallyVisible) 1f else 0f)
    }
    LaunchedEffect(key1 = text, key2 = initiallyVisible) {
        if (!initiallyVisible) {
            alpha.snapTo(0f)
            displayedText = ""
            delay(startDelayMillis)
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = blockFadeInDurationMillis,
                    easing = LinearEasing
                )
            )
            if (blockFadeInDurationMillis == 0 && alpha.value < 1f) alpha.snapTo(1f)

            text.forEachIndexed { index, _ ->
                displayedText = text.substring(0, index + 1)
                delay(typingSpeedPerCharMillis)
            }
        } else {
            alpha.snapTo(1f)
            displayedText = text
        }
    }
    return displayedText
}