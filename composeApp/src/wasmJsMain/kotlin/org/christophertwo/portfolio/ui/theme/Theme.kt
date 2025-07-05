package org.christophertwo.portfolio.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import portfolio.composeapp.generated.resources.BitcountGrid
import portfolio.composeapp.generated.resources.Doto
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.Workbench

@Composable
fun ThemeApp(
    content: @Composable () -> Unit
) {
    val doto = FontFamily(Font(Res.font.Doto))
    val bitcountGrid = FontFamily(Font(Res.font.BitcountGrid))
    val workBench = FontFamily(Font(Res.font.Workbench))
    MaterialTheme(
        colorScheme = scheme(isDark = true),
        typography = Typography(
            titleLarge = TextStyle(fontFamily = bitcountGrid),
            titleMedium = TextStyle(fontFamily = doto),
            titleSmall = TextStyle(fontFamily = workBench),
        ),
        content = {
            Surface(
                color = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxSize(),
                content = {
                    content()
                }
            )
        }
    )
}