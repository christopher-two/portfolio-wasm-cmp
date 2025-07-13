package org.christophertwo.portfolio.ui.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.christophertwo.portfolio.ui.components.IconsDynamics
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.compose_multiplatform
import portfolio.composeapp.generated.resources.web_assembly_icon_white

@Composable
fun TitleApp(
    windowSizeWidth: Int,
    windowSizeHeight: Int
) {
    val uriHandler = LocalUriHandler.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = windowSizeHeight.dp)
            .padding(top = 16.dp)
    ) {
        CardTitle(
            colorBackground = colorScheme.surface,
            colorContent = colorScheme.onSurface,
            windowSizeWidth = windowSizeWidth,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp)
                .align(Alignment.TopStart),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            content = {
                Text(
                    text = "Powered by",
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                    color = colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(Res.drawable.web_assembly_icon_white),
                    contentDescription = "Web Assembly Logo",
                    tint = colorScheme.onSurface,
                    modifier = Modifier.size(IconsDynamics(windowSizeWidth)).clickable {
                        uriHandler.openUri("https://webassembly.org/")
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = "Compose Multiplatform Logo",
                    modifier = Modifier.size(IconsDynamics(windowSizeWidth) + 10.dp).clickable {
                        uriHandler.openUri("https://www.jetbrains.com/compose-multiplatform/")
                    }
                )
            }
        )
    }
}