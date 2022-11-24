package com.tourguide.presentation.ui.details.components.description

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.em
import com.tourguide.presentation.ui.theme.Montserrat

@Composable
fun Description(
    description:String,
) {
    val annotatedText = buildAnnotatedString {

        pushStyle(
            style = ParagraphStyle(
                lineHeight = 1.6.em,
            )
        )

        pushStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onBackground,
                fontFamily = Montserrat,

            ),
        )

        append(description)

        pushStringAnnotation(
            tag = "ReadMore",
            annotation = "ReadMore"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontFamily = Montserrat
            )
        ) {
            append(" Read More")
        }

        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "ReadMore",
                start = offset,
                end = offset
            ).firstOrNull()?.let {

            }
        }
    )
}
