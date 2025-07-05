package org.christophertwo.portfolio

import androidx.compose.runtime.Composable
import org.christophertwo.portfolio.ui.screens.PortfolioStyleCardRoot
import org.christophertwo.portfolio.ui.screens.PortfolioStyleCardViewModel
import org.christophertwo.portfolio.ui.theme.ThemeApp

@Composable
fun App() {
    ThemeApp(
        content = {
            PortfolioStyleCardRoot(viewModel = PortfolioStyleCardViewModel())
        }
    )
}