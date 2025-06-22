package com.example.healthcare

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HeartRiskInputScreen(viewModel: HeartRiskViewModel = viewModel()) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp)) {

        Text("Heart Disease Risk Checker", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        // Input fields
        OutlinedTextField(value = viewModel.bmi, onValueChange = { viewModel.bmi = it }, label = { Text("BMI") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                cursorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black),
            )
        SwitchWithLabel("Smoking", viewModel.smoking) { viewModel.smoking = it }
        SwitchWithLabel("Alcohol Drinking", viewModel.alcoholDrinking) { viewModel.alcoholDrinking = it }
        SwitchWithLabel("Stroke", viewModel.stroke) { viewModel.stroke = it }
        OutlinedTextField(value = viewModel.physicalHealth, onValueChange = { viewModel.physicalHealth = it }, label = { Text("Physical Health (0-30)") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                cursorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black))
        OutlinedTextField(value = viewModel.mentalHealth, onValueChange = { viewModel.mentalHealth = it }, label = { Text("Mental Health (0-30)") },  colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            focusedTextColor = Color.Black))

        SwitchWithLabel("Difficulty Walking", viewModel.diffWalking) { viewModel.diffWalking = it }

        DropdownWithLabel("Sex", viewModel.sex, listOf("Male", "Female")) { viewModel.sex = it }
        DropdownWithLabel("Age Category", viewModel.ageCategory, listOf("18-24", "25-29", "30-34", "35-39", "40-44", "45-49", "50-54", "55-59", "60-64", "65-69", "70-74", "75-79", "80+")) { viewModel.ageCategory = it }
        DropdownWithLabel("Race", viewModel.race, listOf("White", "Black", "Asian", "Other")) { viewModel.race = it }

        DropdownWithLabel("Diabetic", viewModel.diabetic, listOf("Yes", "No", "Borderline", "During Pregnancy")) { viewModel.diabetic = it }
        SwitchWithLabel("Physical Activity", viewModel.physicalActivity) { viewModel.physicalActivity = it }
        DropdownWithLabel("General Health", viewModel.genHealth, listOf("Poor", "Fair", "Good", "Very Good", "Excellent")) { viewModel.genHealth = it }
        OutlinedTextField(value = viewModel.sleepTime, onValueChange = { viewModel.sleepTime = it }, label = { Text("Sleep Time (hours)") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                cursorColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.Black
            ))
        SwitchWithLabel("Asthma", viewModel.asthma) { viewModel.asthma = it }
        SwitchWithLabel("Kidney Disease", viewModel.kidneyDisease) { viewModel.kidneyDisease = it }
        SwitchWithLabel("Skin Cancer", viewModel.skinCancer) { viewModel.skinCancer = it }

        Button(onClick = { viewModel.calculateRisk() }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Calculate Risk")
        }

        Text("Risk: ${viewModel.riskResult}", fontSize = 18.sp, modifier = Modifier.padding(top = 16.dp))
    }
}

@Composable

fun CustomButton(onClick: () -> Unit, modifier: Modifier = Modifier, text: String) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}


@Composable
fun SwitchWithLabel(label: String, state: Boolean, onToggle: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label, modifier = Modifier.weight(1f))
        Switch(checked = state, onCheckedChange = onToggle)
    }
}

@Composable
fun DropdownWithLabel(label: String, selected: String, options: List<String>, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(label)
        Box {
            Text(selected, modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .border(1.dp, Color.Gray)
                .padding(8.dp))
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(item) },
                        onClick = {
                            onSelected(item)
                            expanded = false
                        }
                    )
                }

            }
        }
    }
}
