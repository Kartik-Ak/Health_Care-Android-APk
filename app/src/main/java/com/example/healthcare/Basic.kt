package com.example.healthcare


import android.content.ClipData
import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicAid(){

    Column(modifier = Modifier.fillMaxWidth().padding(30.dp),
        ) {

        Text("Basic Aids\n", fontSize = 25.sp, fontWeight = FontWeight.Bold)

        LazyColumn(modifier = Modifier.fillMaxSize(),){
            item {

                Text("The 7 Steps of First Aid\n", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
            item {
                Text("Step 1: Ensure Safety", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Ensuring safety is the first and foremost first aid step, as it is crucial " +
                        "to make sure that both the first aider and the person in need are not put " +
                        "into further danger. Remember, your safety is paramount. You will not be" +
                        " able to help someone else if you become injured or incapacitated. Always" +
                        " be mindful of the risks and act wisely.\n", fontSize = 15.sp)
            }
            item {
                Text("Step 2: Call for Help", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Knowing when to call 911 is crucial during a first-aid situation. Certain" +
                        " conditions and incidents are time-sensitive and require immediate " +
                        "professional medical intervention. When calling emergency services, try" +
                        " to stay calm and provide clear information about the location, the" +
                        " condition of the injured person, and any other relevant details. Also," +
                        " follow any instructions given by the emergency dispatcher.\n"
                    , fontSize = 15.sp)
            }
            item {
                Text("Step 3: Assess the Situation", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Evaluating the injured person’s condition is a critical step in first aid, " +
                        "as it helps determine the appropriate actions to take. Remember, while" +
                        " evaluating an injured person’s condition, it’s crucial to stay calm and " +
                        "focused. If you are uncertain of what to do, it’s best to wait for " +
                        "professional help while ensuring that the person is safe and as comfortable" +
                        " as possible.\n", fontSize = 15.sp)
            }
            item {
                Text("Step 4: Provide Basic First Aid Procedures if Necessary", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("If you have taken a first-aid training course, you have learned at least 10" +
                        " basic first-aid procedures. These may include techniques to address" +
                        "\n" +
                        "*CPR\n" +
                        "*AED\n" +
                        "*Choking (Heimlich Maneuver)\n" +
                        "*First Aid Basics\n" +
                        "*Medical Emergencies\n" +
                        "*Trauma\n" +
                        "*Bleeding\n" +
                        "*Amputations\n" +
                        "*Poisoning\n" +
                        "*Environmental\n" +
                        "This is the time to use what you know.\n", fontSize = 15.sp)
            }
            item {
                Text("Step 5: Provide Comfort and Reassurance", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Providing comfort and reassurance is a vital component of first aid that " +
                        "often gets overlooked. A calm and supportive presence can help reduce an" +
                        " injured person’s anxiety and pain levels, and can also make them more" +
                        " cooperative during the treatment process.\n", fontSize = 15.sp)
            }
            item {
                Text("Step 6: Handover to Professional Medical Help", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Handing over to professional medical help is a critical final step in first " +
                        "aid. When emergency services arrive, it’s essential to communicate " +
                        "effectively to ensure that the injured person receives the best possible" +
                        " care.\n", fontSize = 15.sp)
            }
            item {
                Text("", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("", fontSize = 15.sp)
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun BasicAidPreview(){

}