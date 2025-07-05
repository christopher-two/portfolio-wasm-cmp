package org.christophertwo.portfolio.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun scheme(
    isDark: Boolean = false
): ColorScheme {
    return if (isDark) {
        darkColorScheme(
            primary = MonoBlueDark,
            onPrimary = MonoDarkOnPrimary,
            primaryContainer = MonoDarkPrimaryContainer,
            onPrimaryContainer = MonoDarkOnPrimary, // Or a slightly different light color if needed for contrast
            inversePrimary = MonoBlueLight, // Lighter blue for inverse on dark

            secondary = MonoBlueLight, // Could be a lighter variant of MonoBlueDark or a distinct tint
            onSecondary = MonoDarkOnSecondary,
            secondaryContainer = MonoDarkSecondaryContainer,
            onSecondaryContainer = MonoDarkOnSecondary,

            tertiary = MonoBlueLight.copy(alpha = 0.8f), // Often a more subtle accent
            onTertiary = MonoDarkOnSecondary,
            tertiaryContainer = MonoDarkSecondaryContainer.copy(alpha = 0.8f),
            onTertiaryContainer = MonoDarkOnSecondary,

            background = MonoDarkBackground,
            onBackground = MonoDarkOnBackground,

            surface = MonoDarkSurface,
            onSurface = MonoDarkOnSurface,

            surfaceVariant = MonoDarkSurfaceContainerHigh, // A common choice for surfaceVariant in dark
            onSurfaceVariant = MonoDarkOnSurface,

            surfaceTint = MonoSurfaceTint, // Your primary color

            inverseSurface = MonoDarkOnBackground, // Light color for dark theme inverse surface
            inverseOnSurface = MonoDarkBackground, // Dark color for text on inverseSurface

            error = DarkErrorRed,
            onError = DarkOnErrorRed,
            errorContainer = DarkErrorContainerRed,
            onErrorContainer = DarkOnErrorContainerRed,

            outline = MonoOutline.copy(alpha = 0.7f), // Adjusted for dark theme visibility
            outlineVariant = MonoOutline.copy(alpha = 0.3f), // More subtle
            scrim = MonoScrim,

            // New M3 Surface Roles for Dark Theme
            surfaceBright = MonoDarkSurfaceBright,
            surfaceContainer = MonoDarkSurfaceContainer,
            surfaceContainerHigh = MonoDarkSurfaceContainerHigh,
            surfaceContainerHighest = MonoDarkSurfaceContainerHighest,
            surfaceContainerLow = MonoDarkSurfaceContainerLow,
            surfaceContainerLowest = MonoDarkSurfaceContainerLowest,
            surfaceDim = MonoDarkSurfaceDim
        )
    } else { // Light Theme
        lightColorScheme(
            primary = MonoBluePrimary,
            onPrimary = Color.White,
            primaryContainer = MonoBlueLight,
            onPrimaryContainer = MonoBlueOnBackground, // Dark text on light blue container
            inversePrimary = MonoBlueDark, // Darker blue for inverse on light

            secondary = MonoBlueDark,
            onSecondary = Color.White,
            secondaryContainer = MonoBlueBackground, // Very light blue
            onSecondaryContainer = MonoBlueOnBackground,

            tertiary = MonoBlueDark.copy(alpha = 0.8f), // Often a more subtle accent
            onTertiary = Color.White,
            tertiaryContainer = MonoBlueBackground.copy(alpha = 0.9f),
            onTertiaryContainer = MonoBlueOnBackground,

            background = MonoBlueBackground,
            onBackground = MonoBlueOnBackground,

            surface = MonoBlueSurface, // Typically white
            onSurface = MonoBlueOnSurface,

            surfaceVariant = MonoLightSurfaceContainerHigh, // A common choice for surfaceVariant in light
            onSurfaceVariant = MonoBlueOnSurface,

            surfaceTint = MonoSurfaceTint, // Your primary color

            inverseSurface = MonoBlueOnBackground, // Dark color for light theme inverse surface
            inverseOnSurface = MonoBlueBackground, // Light color for text on inverseSurface

            error = ErrorRed,
            onError = OnErrorRed,
            errorContainer = ErrorContainerRed,
            onErrorContainer = OnErrorContainerRed,

            outline = MonoOutline,
            outlineVariant = MonoOutline.copy(alpha = 0.5f), // More subtle
            scrim = MonoScrim,

            // New M3 Surface Roles for Light Theme
            surfaceBright = MonoLightSurfaceBright,
            surfaceContainer = MonoLightSurfaceContainer,
            surfaceContainerHigh = MonoLightSurfaceContainerHigh,
            surfaceContainerHighest = MonoLightSurfaceContainerHighest,
            surfaceContainerLow = MonoLightSurfaceContainerLow,
            surfaceContainerLowest = MonoLightSurfaceContainerLowest,
            surfaceDim = MonoLightSurfaceDim
        )
    }
}