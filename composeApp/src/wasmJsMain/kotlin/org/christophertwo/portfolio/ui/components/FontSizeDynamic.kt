package org.christophertwo.portfolio.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun FontSizeTitle(windowSize: Int): TextUnit = when {
    windowSize < 510 -> 50.sp
    windowSize < 710 -> 70.sp
    windowSize < 1000 -> 100.sp
    windowSize > 1000 -> 140.sp
    else -> 140.sp
}

@Composable
fun FontSizeSubtitle(windowSize: Int): TextUnit = when {
    windowSize <= 510 -> 30.sp
    windowSize <= 710 -> 50.sp
    windowSize <= 1000 -> 60.sp
    windowSize >= 1000 -> 100.sp
    else -> 100.sp
}