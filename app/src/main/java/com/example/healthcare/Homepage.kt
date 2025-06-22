package com.example.healthcare

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.healthcare.DataStore.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun ThemePage(
    navController: NavHostController,
    context: Context = LocalContext.current,
    viewModel: MainViewModel
) {
    val firstName by viewModel.firstName.collectAsState()
Box(modifier = Modifier.fillMaxSize().background(color = Color.White))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Hello!", fontSize = 20.sp)
                Text(firstName, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
            Surface(
                modifier = Modifier.size(60.dp),
                shape = RoundedCornerShape(20.dp),
                color = Color.Transparent
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("Services", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(30.dp))

        // Main Card
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            shape = RoundedCornerShape(30.dp),
            shadowElevation = 20.dp
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Brush.linearGradient(
                            listOf(Color(0xFFF3447C), Color(0xFF47D5E7))
                        )
                    )
                    .padding(20.dp)
            ) {
                Column {
                    IconGrid(
                        items = listOf(
                            Pair(R.drawable.heart, "Heart") to { navController.navigate("Heart") },
                            Pair(R.drawable.girl, "Girls") to { navController.navigate("Girl") },
                            Pair(R.drawable.basic, "Basic") to { navController.navigate("Basic") },
                            Pair(R.drawable.hos, "Hospital") to { openNearbyHospitals(context) },
                            Pair(R.drawable.setting,"Setting")to{navController.navigate("Setting")}
                        )
                    )
                }
            }
        }
    }





    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(220.dp))

        val phoneNumber = "112"
        Button(onClick = {EmrgencyCall(context, phoneNumber)

        },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Red,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Red,
            ),
            modifier = Modifier.width(250.dp).height(50.dp)) {


            Text("\uD83D\uDEA8  Emergency Call ")

        }
    }
    val listState = rememberLazyListState()
    val itemCount = 2  // Total items in LazyRow
    var currentIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(7000L) // 2 seconds delay
            currentIndex = (currentIndex + 1) % itemCount
            listState.animateScrollToItem(currentIndex)
        }
    }

    Column(modifier=Modifier.fillMaxWidth().height(820.dp).padding(40.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {

        LazyRow(state = listState,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            item {
                ChatAi(navController)
            }
            item{
                Reports(navController)
            }
        }
    }

}
@Composable
fun IconGrid(items: List<Pair<Pair<Int, String>, () -> Unit>>) {
    val rows = items.chunked(3)
    for (row in rows) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            row.forEach { (iconText, action) ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        modifier = Modifier
                            .size(60.dp)
                            .clickable { action() },
                        color = Color.Transparent,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Image(
                            painter = painterResource(iconText.first),
                            contentDescription = iconText.second,
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(iconText.second, color = Color.White, fontSize = 14.sp)
                }
            }
        }
    }
}


@Composable
fun ChatAi(navController: NavController){

            Surface(modifier = Modifier.width(300.dp).height(150.dp),
                shape = RoundedCornerShape(30.dp),
                color = Color.DarkGray,
                shadowElevation = 5.dp,
                onClick = {navController.navigate("chat")}

                ) {
                
                Box(modifier = Modifier.fillMaxSize())
                 {
                    Image(painter = painterResource(R.drawable.bgim),
                        contentDescription = "Background",
                        contentScale = ContentScale.Crop)

                    Row (modifier = Modifier.fillMaxSize().padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly){
                        Column {
                            Text(
                                "Chat With Our AI", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                "Trained Ai with Tons of Data",
                                fontSize = 13.sp,
                                color = Color.White
                            )

                        }

                    }

                }

            }

        }


@Composable
fun Reports(navController: NavController){
        Surface(modifier = Modifier.width(300.dp).height(150.dp),
            shape = RoundedCornerShape(30.dp),
            color = Color.White,
            shadowElevation = 5.dp,
            onClick = {navController.navigate("Report")}

        ) {

            Box(modifier = Modifier.fillMaxSize())
            {
                Image(painter = painterResource(R.drawable.whitestuff),
                    contentDescription = "White Background",
                    contentScale = ContentScale.Crop)


                Row (modifier = Modifier.fillMaxSize().padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly){


                    Column {
                        Text(
                            "Check Reports", fontSize = 25.sp, fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            "Your Daily Health Report",
                            fontSize = 13.sp,
                            color = Color.Black
                        )

                    }
                    Image(painter = painterResource(R.drawable.rp2),
                        contentDescription = "Background",
                        contentScale = ContentScale.Crop)
                }

            }

        }

    }