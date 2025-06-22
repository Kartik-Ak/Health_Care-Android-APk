package com.example.healthcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.healthcare.ui.theme.HealthCareTheme
import com.example.healthcare.DataStore.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = viewModel()
            HealthCareTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination ="information"){
                    composable("Main") {
                        ThemePage(navController, viewModel = viewModel)
                    }
                    composable("Basic") {
                        BasicAid()
                    }
                    composable("Heart") {
                        HeartRiskInputScreen()
                    }
                    composable("Girl") {
                        Girl(navController)
                    }
                    composable("chat") {
                        ChatBot()
                    }
                    composable ("Setting"){
                        Personinfo(viewModel=viewModel, navController)
                    }
                    composable("Report"){
                        Report(viewModel=viewModel)
                    }
                    composable("information") {
                        Takeinfo(viewModel = viewModel,navController)
                    }
                    composable("2information") {
                        Secondtakeinfo(navController)
                    }
                    composable("Thyroid") {
                        Thyroid()
                    }
                    composable("Breast") {
                        Breast_Cancer()
                    }
                    composable("PCOD") {
                        PCOD()
                    }
                    composable("Infect") {
                        Infection()

                    }
                }
            }
        }
    }
}



