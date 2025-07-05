package org.christophertwo.portfolio.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconsDynamics(
    windowSizeWidth: Int,
): Dp {
    return when {
        windowSizeWidth >= 1000 -> 35.dp
        windowSizeWidth <= 768 -> 30.dp
        windowSizeWidth <= 510 -> 25.dp
        else -> 20.dp
    }
}