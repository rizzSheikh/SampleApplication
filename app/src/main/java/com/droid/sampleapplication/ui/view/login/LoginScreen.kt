package com.droid.sampleapplication.ui.view.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.sampleapplication.R
import com.droid.sampleapplication.ui.components.CustomProgressBar
import com.droid.sampleapplication.ui.theme.SampleApplicationTheme
import com.droid.sampleapplication.ui.theme.customColorsPalette
import com.droid.sampleapplication.ui.view.login.components.SocialMediaLoginRow
import com.droid.sampleapplication.ui.view.login.event.LoginEvent
import com.droid.sampleapplication.ui.view.login.uistate.LoginUiState

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onEvent: (LoginEvent) -> Unit
) {

    var emailAddress by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }

    var password by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }

    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    var isEmailError by rememberSaveable { mutableStateOf(false) }

    var isPassWordError by rememberSaveable { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(content = { padding ->
        Column(
            modifier.padding(
                vertical = padding.calculateTopPadding(),
                horizontal = 16.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login to your Account",
                modifier = Modifier.padding(top = 68.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Column(modifier = Modifier.padding(bottom = 24.dp, top = 28.dp)) {
                OutlinedTextField(
                    value = emailAddress,
                    onValueChange = {
                        emailAddress = it
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "TextField Icon",
                            tint = LocalContentColor.current.copy(alpha = 0.5f),
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Email",
                            modifier = Modifier.wrapContentWidth(),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.outline
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    isError = isEmailError,
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged {
                            if (it.isFocused) {
                                isEmailError = false
                            }
                        },
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = MaterialTheme.colorScheme.primary)
                )
                AnimatedVisibility(visible = isEmailError) {
                    Text(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(top = 2.dp),
                        text = "Please enter valid user id",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Red
                    )
                }
            }
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        if (it.isFocused) {
                            isPassWordError = false
                        }
                    },
                value = password,
                onValueChange = {
                    password = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                isError = isPassWordError,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "TextField Icon",
                        tint = LocalContentColor.current.copy(alpha = 0.5f),
                        modifier = Modifier.size(24.dp)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }) {
                        Icon(
                            painter = if (isPasswordVisible) painterResource(R.drawable.view) else painterResource(
                                R.drawable.hide
                            ),
                            contentDescription = if (isPasswordVisible) "View Password" else "Hide Password",
                            tint = LocalContentColor.current.copy(alpha = 0.8f),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                placeholder = {
                    Text(
                        text = "Password",
                        modifier = Modifier.wrapContentWidth(),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colorScheme.outline
                    )
                },
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = MaterialTheme.colorScheme.primary)
            )
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 28.dp)
            ) {
                Text(
                    text = "Forgot password?",
                    modifier = Modifier
                        .wrapContentWidth()
                        .clickable {
                            //TODO forgot password
                        },
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelLarge
                )
            }
            if (uiState.isLoading) {
                CustomProgressBar()
            } else {
                Button(modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ), onClick = {
                    keyboardController?.hide()
                    if (emailAddress.text.isEmpty()) {
                        isEmailError = true
                        return@Button
                    }
                    if (password.text.isEmpty()) {
                        isEmailError = true
                        return@Button
                    }
                    onEvent(LoginEvent.OnLogInClick(emailAddress.text, password.text))
                }) {
                    Text(
                        text = "Login",
                        modifier = Modifier.wrapContentWidth(),
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            Text(
                text = "- Or sign in with -",
                modifier = Modifier
                    .padding(top = 58.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.customColorsPalette.grayColor
            )
            SocialMediaLoginRow(
                onGoogleLoginClick = {
                    //todo
                },
                onTwitterLoginClick = {
                    //todo
                },
                onFacebookLoginClick = {
                    //todo
                },
                modifier = Modifier.padding(top = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 38.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    4.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Text(
                    text = "Don't have an account?",
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Register",
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    })

}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    SampleApplicationTheme {
        Surface {
            LoginScreen(onEvent = {}, uiState = LoginUiState(isLoading = false))
        }
    }
}