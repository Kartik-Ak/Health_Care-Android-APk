package com.example.healthcare

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HeartRiskViewModel : ViewModel() {
    var bmi by mutableStateOf("")
    var smoking by mutableStateOf(false)
    var alcoholDrinking by mutableStateOf(false)
    var stroke by mutableStateOf(false)
    var physicalHealth by mutableStateOf("")
    var mentalHealth by mutableStateOf("")
    var diffWalking by mutableStateOf(false)
    var sex by mutableStateOf("Male")
    var ageCategory by mutableStateOf("18-24")
    var race by mutableStateOf("White")
    var diabetic by mutableStateOf("No")
    var physicalActivity by mutableStateOf(false)
    var genHealth by mutableStateOf("Good")
    var sleepTime by mutableStateOf("")
    var asthma by mutableStateOf(false)
    var kidneyDisease by mutableStateOf(false)
    var skinCancer by mutableStateOf(false)

    var riskResult by mutableStateOf("")

    fun calculateRisk() {
        val input = HeartRiskInput(
            bmi = bmi.toFloatOrNull() ?: 0f,
            smoking = smoking,
            alcoholDrinking = alcoholDrinking,
            stroke = stroke,
            physicalHealth = physicalHealth.toIntOrNull() ?: 0,
            mentalHealth = mentalHealth.toIntOrNull() ?: 0,
            diffWalking = diffWalking,
            sex = sex,
            ageCategory = ageCategory,
            race = race,
            diabetic = diabetic,
            physicalActivity = physicalActivity,
            genHealth = genHealth,
            sleepTime = sleepTime.toIntOrNull() ?: 0,
            asthma = asthma,
            kidneyDisease = kidneyDisease,
            skinCancer = skinCancer
        )

        riskResult = HeartRiskCalculator.calculateRisk(input)
    }
}
