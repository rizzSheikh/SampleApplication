package com.droid.sampleapplication.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.droid.sampleapplication.data.model.DiseasesData
import com.droid.sampleapplication.ui.navigation.LoginNav
import com.droid.sampleapplication.ui.navigation.detailsScreen
import com.droid.sampleapplication.ui.navigation.homeScreen
import com.droid.sampleapplication.ui.navigation.loginScreen
import com.droid.sampleapplication.ui.navigation.navigateToDetails
import com.droid.sampleapplication.ui.navigation.navigateToHome
import com.droid.sampleapplication.ui.theme.SampleApplicationTheme
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()

            SampleApplicationTheme {
                Surface {
                    NavHost(
                        navController = navController,
                        startDestination = LoginNav
                    ) {

                        //login screen
                        loginScreen(onLoginClick = { navController.navigateToHome() })

                        //home screen
                        homeScreen(onItemClick = { navController.navigateToDetails(it) })

                        //details screen
                        detailsScreen(onBackPress = { navController.popBackStack() })

                    }
                }
            }
        }
    }

    companion object {
        private val moshi = Moshi.Builder().build()
        val diseasesDataAdapter: JsonAdapter<DiseasesData> = moshi.adapter(DiseasesData::class.java)
    }
}