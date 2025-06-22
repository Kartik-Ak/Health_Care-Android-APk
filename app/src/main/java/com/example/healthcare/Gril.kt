package com.example.healthcare

import androidx.collection.intIntMapOf
import androidx.collection.mutableObjectIntMapOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Girl(navController: NavController) {
    val myfont = FontFamily(
        Font(R.font.myf)
    )
    Box(modifier = Modifier.fillMaxSize().background(
        brush = Brush.verticalGradient(
            colors = listOf(
                Color(0xFFca8aa4),Color(0xFFc597c8)
            )
        )
    ),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(R.drawable.flwore),
            contentDescription = "Girl BG",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize())
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(30.dp),
    ) {
        Text("My Problems", fontSize = 25.sp, fontWeight = FontWeight.Bold,
            color = Color.White)
        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            MyCards(
                "Thyroid", "Breast Cancer", R.drawable.thyr, R.drawable.cancer,
                navController,"Thyroid","Breast"
            )

            Spacer(modifier = Modifier.height(20.dp))
            
            Spacer(modifier = Modifier.height(20.dp))

            MyCards(
                "PCOD", "Infection", R.drawable.pcod, R.drawable.ye,
                navController,"PCOD","Infect"
            )

            Spacer(modifier = Modifier.height(50.dp))

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Card(modifier = Modifier.height(139.dp).width(280.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize().background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFca8aa4), Color(0xFFc597c8)
                                )
                            )
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                "Need help with something",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = myfont
                            )
                            Text(
                                "else?",
                                fontSize = 22.sp,
                                color = Color.Black,
                                fontFamily = myfont
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Button(
                                onClick = {navController.navigate("chat")},
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.White,
                                    containerColor = Color(0xFFE989AC),
                                    disabledContentColor = Color.White,
                                    disabledContainerColor = Color.Red
                                ),
                                modifier = Modifier.width(200.dp).height(50.dp)
                            ) {
                                Text("Chat Now", fontSize = 18.sp)
                            }
                        }


                    }
                }

            }
        }
    }
}

@Composable
fun MyCards(info1: String,info2:String, icon1: Int,icon2:Int,navController: NavController,
            nav1:String,nav2:String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Card(
            modifier = Modifier.height(140.dp).width(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFBDDE7)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            onClick = {navController.navigate(nav1)}
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Image(
                    painter = painterResource(icon1),
                    contentDescription = "calender",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(info1, fontSize = 18.sp, fontWeight = FontWeight.Bold)

            }
        }
        Card(
            modifier = Modifier.height(140.dp).width(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFBDDE7)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            onClick = {navController.navigate(nav2)}
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(icon2),
                    contentDescription = "UTI",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(info2, fontSize = 18.sp, fontWeight = FontWeight.Bold)

            }
        }
    }
}


