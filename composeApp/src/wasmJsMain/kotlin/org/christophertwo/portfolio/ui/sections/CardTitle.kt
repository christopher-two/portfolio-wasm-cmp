package org.christophertwo.portfolio.ui.sections

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.christophertwo.portfolio.ui.components.TextAlpha
import org.christophertwo.portfolio.ui.components.FontSizeSubtitle
import org.christophertwo.portfolio.ui.components.FontSizeTitle
import org.christophertwo.portfolio.ui.components.IconsDynamics
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.Wallpapper_Two2
import portfolio.composeapp.generated.resources.arrow_forward_ios_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24
import portfolio.composeapp.generated.resources.github
import portfolio.composeapp.generated.resources.instagram
import portfolio.composeapp.generated.resources.linkedin
import portfolio.composeapp.generated.resources.override

@Composable
fun CardTitle(
    colorBackground: Color,
    colorContent: Color,
    modifier: Modifier = Modifier,
    windowSizeWidth: Int
) {
    val iconsSocial: List<Pair<DrawableResource, String>> = listOf(
        Res.drawable.github to "https://github.com/christopher-two",
        Res.drawable.linkedin to "https://www.linkedin.com/in/christopher-alejandro-maldonado-chavez/",
        Res.drawable.instagram to "https://www.instagram.com/christopher_two_/",
        Res.drawable.override to "https://www.override.com.mx/",
    )
    val uriHandler = LocalUriHandler.current
    var isClicked by remember { mutableStateOf(true) }
    val indexAnimation by rememberInfiniteTransition().animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorBackground.copy(alpha = 0f)
        ),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        isClicked = !isClicked
                    }
                )
            },
        content = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                // IMAGEN DE FONDO - Se coloca PRIMERO para que esté detrás
                Image(
                    painter = painterResource(Res.drawable.Wallpapper_Two2),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize().blur(10.dp),
                    contentScale = ContentScale.Crop,
                )

                // CONTENIDO DE TEXTO - Se coloca DESPUÉS para que esté encima
                Column(
                    modifier = Modifier.fillMaxSize()
                        .background(colorBackground.copy(alpha = 0.4f)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = if (isClicked) "Christopher Two" else "Dany <3",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        fontSize = FontSizeTitle(windowSizeWidth)
                    )
                    // Este texto no se ve afectado por la animación.
                    Text(
                        text = TextAlpha("Desarrollador Multiplataform"),
                        style = MaterialTheme.typography.titleMedium,
                        color = colorContent, // Se especifica el color directamente.
                        textAlign = TextAlign.Center,
                        fontSize = FontSizeSubtitle(windowSizeWidth)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        content = {
                            iconsSocial.forEachIndexed { _, social ->
                                Icon(
                                    painter = painterResource(social.first),
                                    contentDescription = null,
                                    tint = colorScheme.onSurface,
                                    modifier = Modifier
                                        .size(IconsDynamics(windowSizeWidth))
                                        .clickable {
                                            uriHandler.openUri(social.second)
                                        }
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(Res.drawable.arrow_forward_ios_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24),
                        contentDescription = "Arrow",
                        tint = colorContent,
                        modifier = Modifier
                            .rotate(90f)
                            .padding(bottom = 10.dp)
                            .offset(x = 10.dp * indexAnimation)
                            .size(30.dp)
                    )
                }
            }
        }
    )
}