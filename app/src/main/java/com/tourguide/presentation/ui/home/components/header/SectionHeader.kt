package com.tourguide.presentation.ui.home.components.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tourguide.presentation.ui.components.buttons.TextButton
import com.tourguide.presentation.ui.components.typography.Heading
import com.tourguide.presentation.ui.components.typography.HeadingVariant

@Composable
fun SectionHeader(
    title: String,
    onClick: () -> Unit,
) {
    Row (
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Heading(text = title, headingVariant = HeadingVariant.Small, fontWeight = FontWeight.Medium)
        TextButton(
            text = "See All",
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.body2,
            onClick = onClick
        )
    }
}
