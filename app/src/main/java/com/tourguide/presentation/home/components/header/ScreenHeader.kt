package com.tourguide.presentation.home.components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.tourguide.presentation.ui.components.typography.Body
import com.tourguide.presentation.ui.components.typography.Heading

@Composable
fun ScreenHeader() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.fairtravel4u.org/wp-content/uploads/2018/06/sample-profile-pic.png")
                    .crossfade(true)
                    .build()
            ),
            contentDescription = "Profile",
            modifier = Modifier.size(36.dp).clip(shape = RoundedCornerShape(36.dp)),
        )
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
            Body(text="Kolkata, India")
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = "Location",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier.size(18.dp)
            )
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
    Column(verticalArrangement = Arrangement.spacedBy((-4).dp), modifier = Modifier.padding(horizontal = 24.dp)) {
        Body(text = "Welcome Back,")
        Heading(text = "Adrian Sajjan", fontWeight = FontWeight.Medium)
    }
}