package org.christophertwo.portfolio.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.browser.window
import org.christophertwo.portfolio.ui.sections.TitleApp

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
                }
            )
        }
    )
}