package com.example.healthcare

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthcare.DataStore.MainViewModel

@Composable
fun Report(viewModel: MainViewModel) {

    val blood by viewModel.bloodGroup.collectAsState()
    val weight by viewModel.weight.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFD1E1E2))
    ){

        Column (modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
        ) {
            Text("Report", fontWeight = FontWeight.Bold, fontSize = 30.sp)

            Spacer(modifier = Modifier.height(30.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFA9DCE7)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Transparent)
                    ) {

                        Text("Heart Rate", fontSize = 20.sp,)

                        Spacer(modifier = Modifier.weight(1f))
                        Box() {
                            Image(
                                painter = painterResource(R.drawable.hr),
                                contentDescription = "",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.height(65.dp)
                            )
                        }
                    }


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                    ) {

                        Text("96", fontSize = 40.sp)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("bpm", fontSize = 20.sp,)
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .background(
                            color = Color.Transparent
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFFE86D6D), Color(0xFFD1E1E2)
                                    )
                                )
                            )
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)) {
                            Image(
                                painter = painterResource(R.drawable.blg),
                                contentDescription = "Blood Group",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                "Blood Group", fontSize = 17.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(blood, fontSize = 25.sp, color = Color.Black,
                                fontWeight = FontWeight.Bold)

                        }

                    }
                }
                Card(
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp)
                        .background(
                            color = Color.Transparent
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF74DE85), Color(0xFFD1E1E2)
                                    )
                                )
                            )
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)) {
                            Image(
                                painter = painterResource(R.drawable.weight),
                                contentDescription = "Blood Group",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                "Weight", fontSize = 17.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(15.dp))

                            Text("$weight kg", fontSize = 25.sp, color = Color.Black,
                                fontWeight = FontWeight.Bold)

                        }

                    }
                }


            }
            Spacer(modifier = Modifier.height(30.dp))
            Text("Your Reports", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(30.dp))

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally){

                Card(modifier = Modifier
                    .height(60.dp)
                    .width(300.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE8E8E9),
                        contentColor = Color.Black
                    ),
                    elevation = (CardDefaults.cardElevation(10.dp))) {

                    Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                        ){
                        Image(painter = painterResource(R.drawable.documents),
                            contentDescription = "Document",
                            contentScale = ContentScale.Fit)

                        Spacer(modifier = Modifier.width(15.dp))

                        Text("Heart Prediction Report", fontSize = 17.sp)

                    }

                }
                Spacer(modifier = Modifier.height(30.dp))

                Card(modifier = Modifier
                    .height(60.dp)
                    .width(300.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE8E8E9),
                        contentColor = Color.Black
                    ),
                    elevation = (CardDefaults.cardElevation(10.dp))) {

                    Row(modifier = Modifier.fillMaxWidth().padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(painter = painterResource(R.drawable.documents),
                            contentDescription = "Document",
                            contentScale = ContentScale.Fit)

                        Spacer(modifier = Modifier.width(15.dp))

                        Text("Other Reports", fontSize = 17.sp)

                    }

                }
            }


        }

    }
}
