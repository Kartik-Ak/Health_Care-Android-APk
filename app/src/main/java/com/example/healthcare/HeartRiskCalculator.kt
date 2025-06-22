package com.example.healthcare

data class HeartRiskInput(
    val bmi: Float,
    val smoking: Boolean,
    val alcoholDrinking: Boolean,
    val stroke: Boolean,
    val physicalHealth: Int,
    val mentalHealth: Int,
    val diffWalking: Boolean,
    val sex: String,
    val ageCategory: String,
    val race: String,
    val diabetic: String,
    val physicalActivity: Boolean,
    val genHealth: String,
    val sleepTime: Int,
    val asthma: Boolean,
    val kidneyDisease: Boolean,
    val skinCancer: Boolean
)

object HeartRiskCalculator {
    fun calculateRisk(input: HeartRiskInput): String {
        var score = 0

        if (input.smoking) score += 10
        if (input.alcoholDrinking) score += 5
        if (input.stroke) score += 15
        if (input.diffWalking) score += 10
        if (input.bmi > 30) score += 10
        if (input.physicalHealth > 10) score += 10
        if (input.mentalHealth > 10) score += 5
        if (!input.physicalActivity) score += 10
        if (input.genHealth == "Poor") score += 15
        if (input.diabetic == "Yes" || input.diabetic == "Borderline") score += 10
        if (input.kidneyDisease) score += 10
        if (input.sleepTime < 5 || input.sleepTime > 10) score += 5
        if (input.ageCategory in listOf("65-69", "70-74", "75-79", "80+")) score += 15

        // Normalize score
        val riskPercent = (score * 2).coerceAtMost(100)
        return "$riskPercent% chance of Heart Disease"
    }
}
