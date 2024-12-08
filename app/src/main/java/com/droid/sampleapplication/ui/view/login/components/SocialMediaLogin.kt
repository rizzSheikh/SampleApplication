package com.droid.sampleapplication.ui.view.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.sampleapplication.R
import com.droid.sampleapplication.ui.theme.SampleApplicationTheme

@Composable
fun SocialMediaLoginRow(
    modifier: Modifier = Modifier,
    onGoogleLoginClick: () -> Unit,
    onFacebookLoginClick: () -> Unit,
    onTwitterLoginClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            16.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onGoogleLoginClick, modifier = Modifier.size(38.dp)) {
            Image(
                painterResource(R.drawable.google),
                contentDescription = "Google Logo",
            )
        }

        IconButton(onClick = onFacebookLoginClick, modifier = Modifier.size(38.dp)) {
            Image(
                painterResource(R.drawable.facebook),
                contentDescription = "Google Logo",
            )
        }

        IconButton(onClick = onTwitterLoginClick, modifier = Modifier.size(38.dp)) {
            Image(
                painterResource(R.drawable.twitter),
                contentDescription = "Google Logo",
            )
        }
    }
}

@Preview
@Composable
private fun SocialMediaLoginRowPreview() {
    SampleApplicationTheme {
        Surface {
            SocialMediaLoginRow(
                onGoogleLoginClick = {},
                onFacebookLoginClick = {},
                onTwitterLoginClick = {})
        }
    }
}