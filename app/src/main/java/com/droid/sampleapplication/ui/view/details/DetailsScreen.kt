package com.droid.sampleapplication.ui.view.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droid.sampleapplication.data.model.DiseasesData
import com.droid.sampleapplication.ui.theme.SampleApplicationTheme
import com.droid.sampleapplication.ui.view.components.AppBar
import com.droid.sampleapplication.ui.view.details.components.ExpandableCard

@Composable
fun DetailsScreen(
    diseasesData: DiseasesData, onBackPress: () -> Unit
) {
    Scaffold(topBar = {
        AppBar(title = diseasesData.name, onBackPress = onBackPress)
    }, content = { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 16.dp, start = 8.dp, end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.End
        ) {
            item {
                ExpandableCard(title = "Description", isExpanded = true, content = {
                    Text(
                        text = diseasesData.description,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 10.dp)
                    )
                })
            }

            item {
                ExpandableCard(title = "Symptoms", content = {
                    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                        diseasesData.symptoms.forEach {
                            Text(
                                text = "- $it",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp)
                            )
                        }
                    }
                })
            }

            item {
                ExpandableCard(title = "Medications", content = {
                    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                        diseasesData.medications.forEach {
                            Text(
                                text = "• ${it.name}",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )
                            Text(
                                text = "   - Dosage : ${it.dosage}",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp)
                            )
                            Text(
                                text = "• Description : ${it.description}",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp)
                            )
                        }
                    }
                })
            }

            item {
                ExpandableCard(title = "Lab Test", content = {
                    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                        diseasesData.labTests.forEach {
                            Text(
                                text = "• ${it.name}",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )
                            Text(
                                text = "   - Range : ${it.normalRange}",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp)
                            )
                            Text(
                                text = "• Description : ${it.description}",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp)
                            )
                        }
                    }
                })
            }
        }
    })
}

@Preview
@Composable
private fun DetailsScreenPreview() {
    SampleApplicationTheme {
        Surface {
            DetailsScreen(diseasesData = DiseasesData(
                description = "Sample description",
                id = 1,
                labTests = listOf(),
                medications = listOf(),
                name = "Diabetes",
                symptoms = listOf()
            ), onBackPress = {})
        }
    }
}