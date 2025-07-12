package org.christophertwo.portfolio.ui.components.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.arrow_back_ios_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24
import portfolio.composeapp.generated.resources.arrow_forward_ios_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24

data class Project(
    val name: String,
    val platform: String,
    val level: ProjectLevel,
    val imageUrl: String,
    val description: String = "",
    val detailedDescription: String = "",
    val technologies: List<String> = emptyList(),
    val images: List<String> = emptyList()
)

enum class ProjectLevel(val displayName: String, val color: Color) {
    PROFESSIONAL("Profesional", Color(0xFF4CAF50)),
    PERSONAL("Personal", Color(0xFF2196F3))
}

@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(500.dp)
            .height(500.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(alpha = 0.3f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Imagen del proyecto
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray.copy(alpha = 0.2f)
                )
            ) {
                AsyncImage(
                    model = project.imageUrl,
                    contentDescription = "Imagen de ${project.name}",
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(1.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del proyecto con estilo punteado
            Text(
                text = project.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall.copy(
                    letterSpacing = 2.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Plataforma
            Text(
                text = project.platform,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    letterSpacing = 1.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Nivel del proyecto
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = project.level.color.copy(alpha = 0.2f)
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        project.level.color
                    )
                ) {
                    Text(
                        text = project.level.displayName,
                        fontSize = 12.sp,
                        color = project.level.color,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ProjectsGrid(
    projects: List<Project>,
    modifier: Modifier = Modifier,
    windowSizeWidth: Int
) {
    var selectedProject by remember { mutableStateOf<Project?>(null) }
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Estados para el scroll continuo
    var isScrollingLeft by remember { mutableStateOf(false) }
    var isScrollingRight by remember { mutableStateOf(false) }

    // Función para scroll suave
    fun scrollLeft() {
        coroutineScope.launch {
            val currentIndex = scrollState.firstVisibleItemIndex
            if (currentIndex > 0) {
                scrollState.animateScrollToItem(maxOf(0, currentIndex - 1))
            }
        }
    }

    fun scrollRight() {
        coroutineScope.launch {
            val currentIndex = scrollState.firstVisibleItemIndex
            if (currentIndex < projects.size - 1) {
                scrollState.animateScrollToItem(minOf(projects.size - 1, currentIndex + 1))
            }
        }
    }

    // Efecto para scroll continuo
    LaunchedEffect(isScrollingLeft) {
        while (isScrollingLeft) {
            scrollLeft()
            delay(150) // Velocidad del scroll continuo
        }
    }

    LaunchedEffect(isScrollingRight) {
        while (isScrollingRight) {
            scrollRight()
            delay(150) // Velocidad del scroll continuo
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            // Botón izquierdo
            if (scrollState.firstVisibleItemIndex > 0 && windowSizeWidth > 700) {
                ScrollButton(
                    icon = Res.drawable.arrow_back_ios_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24,
                    onClick = { scrollLeft() },
                    onPressStart = { isScrollingLeft = true },
                    onPressEnd = { isScrollingLeft = false },
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp), // Espacio para los botones
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Top,
                state = scrollState
            ) {
                items(projects) { project ->
                    ProjectCard(
                        project = project,
                        modifier = Modifier.width(
                            if (windowSizeWidth > 700) 500.dp else 300.dp
                        ),
                        onClick = { selectedProject = project }
                    )
                }
            }

            if (scrollState.firstVisibleItemIndex < projects.size - 1 && windowSizeWidth > 700) {
                ScrollButton(
                    icon = Res.drawable.arrow_forward_ios_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24,
                    onClick = { scrollRight() },
                    onPressStart = { isScrollingRight = true },
                    onPressEnd = { isScrollingRight = false },
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    )

    // Dialog de detalle del proyecto
    selectedProject?.let { project ->
        ProjectDetailDialog(
            project = project,
            isOpen = true,
            onDismiss = { selectedProject = null }
        )
    }
}

@Composable
private fun ScrollButton(
    icon: DrawableResource,
    onClick: () -> Unit,
    onPressStart: () -> Unit,
    onPressEnd: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isPressed by remember { mutableStateOf(false) }

    // Efecto para manejar el click único vs presión continua
    LaunchedEffect(isPressed) {
        if (isPressed) {
            onPressStart()
            delay(500) // Delay inicial antes de empezar scroll continuo
            // El scroll continuo se maneja en el LaunchedEffect del composable padre
        } else {
            onPressEnd()
        }
    }

    Card(
        modifier = modifier
            .size(48.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = { offset ->
                        isPressed = true
                        onClick() // Click inmediato
                        tryAwaitRelease() // Espera hasta que se suelte
                        isPressed = false
                    }
                )
            }
            .zIndex(5f),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ProjectDetailDialog(
    project: Project,
    isOpen: Boolean,
    onDismiss: () -> Unit
) {
    if (isOpen) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.8f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1A1A1A)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {
                    // Header con botón de cerrar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = project.name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )

                        IconButton(
                            onClick = onDismiss,
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.White.copy(alpha = 0.1f)
                            )
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.arrow_forward_ios_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24),
                                contentDescription = "Cerrar",
                                tint = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Carousel de imágenes
                    if (project.images.isNotEmpty()) {
                        LazyRow(
                            modifier = Modifier.height(200.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(project.images) { imageUrl ->
                                Card(
                                    modifier = Modifier
                                        .width(300.dp)
                                        .height(200.dp),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    AsyncImage(
                                        model = imageUrl,
                                        contentDescription = "Imagen del proyecto",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    // Información del proyecto
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Plataforma
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF2196F3).copy(alpha = 0.2f)
                            )
                        ) {
                            Text(
                                text = project.platform,
                                fontSize = 12.sp,
                                color = Color(0xFF2196F3),
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        // Nivel
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = project.level.color.copy(alpha = 0.2f)
                            )
                        ) {
                            Text(
                                text = project.level.displayName,
                                fontSize = 12.sp,
                                color = project.level.color,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Descripción detallada
                    Text(
                        text = "Descripción",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = project.detailedDescription.ifEmpty { "Descripción no disponible" },
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.8f),
                        lineHeight = 20.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Tecnologías
                    if (project.technologies.isNotEmpty()) {
                        Text(
                            text = "Tecnologías",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(project.technologies) { tech ->
                                Card(
                                    shape = RoundedCornerShape(20.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFF4CAF50).copy(alpha = 0.2f)
                                    ),
                                    border = androidx.compose.foundation.BorderStroke(
                                        1.dp,
                                        Color(0xFF4CAF50)
                                    )
                                ) {
                                    Text(
                                        text = tech,
                                        fontSize = 12.sp,
                                        color = Color(0xFF4CAF50),
                                        modifier = Modifier.padding(
                                            horizontal = 12.dp,
                                            vertical = 6.dp
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}