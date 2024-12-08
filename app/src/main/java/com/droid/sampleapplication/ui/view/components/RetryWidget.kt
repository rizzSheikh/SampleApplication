package com.droid.sampleapplication.ui.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.sampleapplication.ui.theme.SampleApplicationTheme

@Composable
fun RetryErrorText(modifier: Modifier = Modifier, onRetryClicked: () -> Unit) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Something went wrong, Please retry",
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        IconButton(onClick = onRetryClicked, modifier = Modifier.padding(end = 4.dp)) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Refresh Icon",
                modifier = Modifier.size(32.dp),
                tint = Color.Red
            )
        }
    }
}

@Preview
@Composable
private fun RetryErrorTextPreview() {
    SampleApplicationTheme {
        Surface {
            RetryErrorText(onRetryClicked = {})
        }
    }
}