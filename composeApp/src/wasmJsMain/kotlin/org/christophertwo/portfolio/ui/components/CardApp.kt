package org.christophertwo.portfolio.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun CardApp(
    title: String,
    containerColor: Color,
    contentColor: Color,
    fonSize: TextUnit,
    isHovered: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    modifier: Modifier = Modifier,
    onCardClicked: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .fillMaxSize()
            .hoverable(
                interactionSource = interactionSource ?: MutableInteractionSource(),
                enabled = isHovered,
            )
            .pointerInput(Unit) {
                detectTapGestures { onCardClicked() }
            },
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    fontSize = fonSize,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    )
}