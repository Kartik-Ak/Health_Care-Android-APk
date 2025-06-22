package com.example.healthcare
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.healthcare.DataStore.MainViewModel
import kotlinx.coroutines.Job

@SuppressLint("SuspiciousIndentation")
@Composable
fun Takeinfo(viewModel: MainViewModel,navController: NavController) {

    val firstName by viewModel.firstName.collectAsState()
    val secondName by viewModel.secondName.collectAsState()
    val age by viewModel.age.collectAsState()
    val height by viewModel.height.collectAsState()
    val weight by viewModel.weight.collectAsState()
    val gender by viewModel.gender.collectAsState()
    val bloodGroup by viewModel.bloodGroup.collectAsState()

    var firstNameInput by remember { mutableStateOf(firstName) }
    var secondNameInput by remember { mutableStateOf(secondName) }
    var ageInput by remember { mutableStateOf(age) }
    var heightInput by remember { mutableStateOf(height) }
    var weightInput by remember { mutableStateOf(weight) }

    val genders = listOf("Male", "Female", "Other")
    val bloodGroups = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")

    var genderExpanded by remember { mutableStateOf(false) }
    var bloodGroupExpanded by remember { mutableStateOf(false) }

    var selectedBloodGroup by remember { mutableStateOf(bloodGroups[0]) }
    var selectedGender by remember { mutableStateOf(genders[0]) }

    val wl = FontFamily(Font(R.font.wel))
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(270.dp).background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF00C853), Color(0xFF))
                )
            ),
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("Hey", fontSize = 26.sp, fontFamily = wl, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(15.dp))
                Text("Welcome To", fontSize = 26.sp, fontFamily = wl, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(15.dp))
                Text("Healthcare", fontSize = 36.sp, fontFamily = wl, fontWeight = FontWeight.Bold)
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Myoutline(
                label = "Name",
                value = firstNameInput,
                onValueChange = {
                    firstNameInput = it
                    viewModel.saveFirstName(it)
                },
            )

            Spacer(modifier = Modifier.height(20.dp))
            Myoutline(
                label = "Secound Name",
                value = secondNameInput,
                onValueChange = {
                    secondNameInput = it
                    viewModel.saveSecondName(it)
                },
            )

            Spacer(modifier = Modifier.height(20.dp))
            Myoutline(
                label = "Age",
                value = ageInput,
                KeyboardType.Number,
                onValueChange = {
                    ageInput = it
                    viewModel.saveAge(it)
                },
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Dropdown(
                    options = bloodGroups,
                    selectedOption = selectedBloodGroup,
                    onOptionSelected = {
                        selectedBloodGroup = it
                        viewModel.saveBloodGroup(it) // ✅ save to ViewModel
                    }
                )
                Dropdown(
                    options = genders,
                    selectedOption = selectedGender,
                    onOptionSelected = {
                        selectedGender = it
                        viewModel.saveGender(it) // ✅ save to ViewModel
                    }
                )

            }
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Mytextfield(
                    "Height",
                    "Cm",
                    value = heightInput,
                    onValueChange = {
                        heightInput = it
                        viewModel.saveWeight(it)
                    })


                Mytextfield(
                    "Weight",
                    "kg",
                    value = weightInput,
                    onValueChange = {
                        weightInput = it
                        viewModel.saveWeight(it)
                    })
            }

            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        navController.navigate("Main")
                    },
                    modifier = Modifier.width(240.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    )
                ) {
                    Text("Next->")
                }
            }
        }
    }
}

@Composable
    fun Myoutline(
        label: String,
        value: String,
        keyboardType: KeyboardType = KeyboardType.Text,
        onValueChange: (String) -> Unit
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                cursorColor = Color.Black
            ),

        )
    }

@Composable
    fun Mytextfield(Mylabel1: String,
                    Sufix:String,
                    value: String,
                    onValueChange: (String) -> Unit) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.width(150.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = Color.Black
            ),
            placeholder = { Text(Mylabel1, color = Color.Black) },

            suffix = {Text(Sufix, color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp)}
        )
    }

//ye 2 wali screen h habits ki
@Composable
fun Secondtakeinfo(navController: NavHostController) {
    val wl = FontFamily(Font(R.font.wel))
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxWidth().height(240.dp).background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF07bbe3),Color(0xFF0745E3))
                ),
                shape = RoundedCornerShape(bottomEnd =  30.dp, bottomStart = 30.dp)
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(10.dp),
            ) {
                Spacer(modifier= Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Text(
                          "Let’s discuss your \nlifestyle" +
                                  " habits and \nunderstand\n" +
                                  " your current health\n" +
                                  " condition.\n",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = wl
                        )
                        Image(
                            painter = painterResource(R.drawable.doc),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(170.dp)
                        )
                    }
                }


            }/*
        Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {

            Text("Smoking", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            val options1 = listOf("Regular Smoker", "Sometime", "Never Smoke")
            Optionsw(options1)
            Spacer(modifier = Modifier.height(10.dp))

            Text("Alcohol", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            val options2 = listOf("Wekend Only", "Once a month", "Never Drink")
            Optionsw(options2)
            Spacer(modifier = Modifier.height(10.dp))

            Text("Physical Activity", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            val options3 = listOf("Running", "GYM", "Walking", "No Activity")
            Optionsw(options2)
            Spacer(modifier = Modifier.height(10.dp))


            Text("Junk Food", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            val options4 = listOf("Eat a Lot", "Eat Sometime", "No junk Food")
            Optionsw(options4)
            Spacer(modifier = Modifier.height(10.dp))


            Text("Hear Rate", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            val options5 = listOf("60-80", "70-100", "80-120", "Don't Know")
            Optionsw(options5)
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
*/
                Button(
                    onClick = {
                        navController.navigate("Main")
                    },
                    modifier = Modifier.width(240.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Black
                    )
                ) {
                    Text("Next->")
                }

            }
        }
/*
        }
    }*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Optionsw(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier.menuAnchor(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.White)
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption, color = Color.Black) },
                    onClick = {
                        onOptionSelected(selectionOption)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Previ(){

}

