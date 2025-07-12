package org.christophertwo.portfolio.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.browser.window
import org.christophertwo.portfolio.ui.components.FontSizeTitle
import org.christophertwo.portfolio.ui.components.Projects
import org.christophertwo.portfolio.ui.components.Skills
import org.christophertwo.portfolio.ui.components.TitleApp

@Composable
fun PortfolioStyleCardRoot(
    viewModel: PortfolioStyleCardViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    PortfolioStyleCardScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
private fun PortfolioStyleCardScreen(
    state: PortfolioStyleCardState,
    onAction: (PortfolioStyleCardAction) -> Unit,
) {
    var windowSize by remember { mutableStateOf(window.innerWidth to window.innerHeight) }
    val (windowSizeWidth, windowSizeHeight) = windowSize

    LaunchedEffect(Unit) {
        window.addEventListener(
            type = "resize",
            callback = { event ->
                windowSize = window.innerWidth to window.innerHeight
            }
        )
    }

    Scaffold(
        containerColor = colorScheme.background.copy(alpha = 0.6f),
        contentColor = colorScheme.onBackground,
        modifier = Modifier.fillMaxSize(),
        content = {
            LazyColumn(
                contentPadding = it,
                modifier = Modifier.fillMaxSize(),
                content = {
                    item { TitleApp(windowSizeWidth, windowSizeHeight) }
                    item {
                        Text(
                            text = "Proyectos",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth().padding(top = 50.dp),
                            fontSize = FontSizeTitle(windowSize = windowSizeWidth)
                        )
                    }
                    item { Projects(windowSizeWidth, windowSizeHeight) }
                    item {
                        Text(
                            text = "Habilidades",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = FontSizeTitle(windowSize = windowSizeWidth)
                        )
                    }
                    item {
                        Skills(windowSizeWidth, windowSizeHeight)
                    }
                }
            )
        }
    )
}