package com.droid.sampleapplication.ui.view.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.sampleapplication.ui.components.CustomProgressBar
import com.droid.sampleapplication.ui.theme.SampleApplicationTheme
import com.droid.sampleapplication.ui.theme.customColorsPalette
import com.droid.sampleapplication.ui.view.components.RetryErrorText
import com.droid.sampleapplication.ui.view.components.DrawerAppBar
import com.droid.sampleapplication.ui.view.home.event.HomeEvent
import com.droid.sampleapplication.ui.view.home.uistate.HomeUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onEvent: (HomeEvent) -> Unit
) {

    val pullToRefreshState = rememberPullToRefreshState()

    Scaffold(
        topBar = {
            DrawerAppBar(title = "Home", onProfileClick = {
                //todo
            }, onDrawerMenuClick = {
                //todo
            })
        },
        content = { paddingValues ->
            Column(
                modifier = modifier
                    .padding(paddingValues = paddingValues)
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "Welcome Back ${uiState.userName},",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start
                )
                AnimatedVisibility(visible = uiState.isLoading) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CustomProgressBar()
                    }
                }
                AnimatedVisibility(visible = uiState.showErrorAndRetry) {
                    RetryErrorText(onRetryClicked = {
                        onEvent(HomeEvent.OnRetryClicked)
                    })
                }
                AnimatedVisibility(visible = uiState.diseasesResponseData != null) {
                    PullToRefreshBox(
                        isRefreshing = uiState.isRefreshing,
                        state = pullToRefreshState,
                        onRefresh = { onEvent(HomeEvent.OnRefresh) },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
                            items(
                                items = uiState.diseasesResponseData?.diseasesData ?: emptyList()
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 10.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    shadowElevation = 4.dp,
                                    onClick = {
                                        onEvent(HomeEvent.OnItemClick(it))
                                    }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(all = 8.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Text(
                                            it.name,
                                            modifier = Modifier
                                                .padding(all = 4.dp)
                                                .weight(1f)
                                        )
                                        Icon(
                                            imageVector = Icons.Filled.KeyboardArrowRight,
                                            contentDescription = "Refresh Icon",
                                            modifier = Modifier.size(28.dp),
                                            tint = MaterialTheme.customColorsPalette.grayColor
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}


@Preview
@Composable
private fun HomeScreenPreview() {
    SampleApplicationTheme {
        Surface {
            HomeScreen(uiState = HomeUiState(), onEvent = {})
        }
    }
}