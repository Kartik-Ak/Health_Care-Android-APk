package com.example.healthcare

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DillUi(){
    var re by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize().background(
        brush = Brush.verticalGradient(
            colors = listOf(
                androidx.compose.ui.graphics.Color(0xFF960a00),
                androidx.compose.ui.graphics.Color(0xFFeba7a2)
            )
        )
    ))
    Column (modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){

        Card(modifier = Modifier.height(450.dp).width(300.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFbfbfbf)
            )
            ) {
            Column (modifier = Modifier.fillMaxSize().padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally){

                TCards("Name: ", re){
                    newValue->
                    re=newValue
                }

                Spacer(modifier = Modifier.height(25.dp))

                TCards("BMI ", re){
                        newValue->
                    re=newValue
                }

                Spacer(modifier = Modifier.height(25.dp))

                TCards("Smoking  ", re){
                        newValue->
                    re=newValue
                }

                Spacer(modifier = Modifier.height(25.dp))

                TCards("Info : ", re){
                        newValue->
                    re=newValue
                }

                Spacer(modifier = Modifier.height(25.dp))

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White,
                        disabledContentColor = Color.Black
                    ),
                    modifier = Modifier.width(150.dp)) {
                    Text("Submit")

                }

            }
        }
    }
}


@Composable
fun TCards(t: String, r: String,onValueChange: (String) -> Unit){
    TextField(
    value = r,
    onValueChange = onValueChange,
    label = { Text(t, color = Color.Black) },
    colors = TextFieldDefaults.colors(
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
    ),
    shape = RoundedCornerShape(15.dp)
)

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DillUiPreview(){
    DillUi()
}