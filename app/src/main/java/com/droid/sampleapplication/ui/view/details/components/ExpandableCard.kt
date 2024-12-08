package com.droid.sampleapplication.ui.view.details.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.sampleapplication.ui.theme.SampleApplicationTheme

@Composable
fun ExpandableCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    title: String,
    isExpanded: Boolean = false
) {

    var isExpanded by rememberSaveable { mutableStateOf(isExpanded) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { isExpanded = !isExpanded },
        shape = RoundedCornerShape(6.dp),
        shadowElevation = 4.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .animateContentSize() // Automatically animate size changes
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = title,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Arrow Icon",
                    tint = LocalContentColor.current.copy(alpha = 0.8f),
                    modifier = Modifier.size(28.dp)
                )
            }

            AnimatedVisibility(visible = isExpanded) {
                content()
            }
        }
    }
}

@Preview
@Composable
private fun ExpandableCardPreview() {
    SampleApplicationTheme {
        Surface {
            ExpandableCard(content = {}, title = "Title")
        }
    }
}