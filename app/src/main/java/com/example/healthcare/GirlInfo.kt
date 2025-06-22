package com.example.healthcare

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Thyroid(){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp).verticalScroll(scrollState),

    ) {

        Text("Thyroid Problems in Girls\n", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Text("What is Thyroid\n", fontSize = 20.sp,)
        Text("The thyroid is a small, butterfly-shaped gland located at the front of the neck, just " +
                "below the Adam's apple. It plays a vital role in controlling the body’s metabolism " +
                "by producing thyroid hormones – mainly T3 (triiodothyronine) and T4 (thyroxine)." +
                " These hormones regulate energy, growth, mood, heart rate, and many other bodily " +
                "functions.\n")
        Text(" How Does Thyroid Problems Happen in Girls?\n ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Thyroid disorders occur when the thyroid gland produces too little or too much hormone.\n" +
                "\n" +
                "a. Hypothyroidism (Underactive Thyroid):\n" +
                "The thyroid produces too little hormone.\n" +
                "\n" +
                "Common in teenage girls due to hormonal changes, autoimmune diseases like" +
                " Hashimoto’s thyroiditis.\n" +
                "\n" +
                "Symptoms:\n" +
                "\n" +
                "Fatigue\n" +
                "\n" +
                "Weight gain\n" +
                "\n" +
                "Irregular or heavy periods\n" +
                "\n" +
                "Dry skin\n" +
                "\n" +
                "Depression or mood swings\n" +
                "\n" +
                "Slow growth or delayed puberty\n" +
                "\n")

        Text("Causes of Thyroid Problems in Girls:\n", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Autoimmune disorders (like Hashimoto’s or Graves’ disease)\n" +
                "\n" +
                "1.Genetic factors (family history)\n" +
                "\n" +
                "2.Puberty and hormonal changes\n" +
                "\n" +
                "3.Iodine deficiency\n" +
                "\n" +
                "4.Certain medications or treatments (like radiation)\n")
        Text("Prevention and Management:\n", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("While not all thyroid problems can be prevented (especially autoimmune ones), some steps can help manage or reduce the risk:\n" +
                "\n" +
                "a. Healthy Diet:\n" +
                "Ensure proper intake of iodine (found in iodized salt, dairy, fish).\n" +
                "\n" +
                "Eat a balanced diet rich in fruits, vegetables, and whole grains.\n" +
                "\n" +
                "Avoid excess soy and goitrogenic foods (like raw cabbage or cauliflower) if at risk.\n" +
                "\n" +
                "b. Regular Check-ups:\n" +
                "Get thyroid tests (TSH, T3, T4) if there’s a family history or symptoms.\n" +
                "\n" +
                "Pediatricians often check thyroid levels during puberty if irregular symptoms appear.\n" +
                "\n" +
                "c. Stress Management:\n" +
                "High stress can trigger or worsen thyroid issues. Practicing yoga, meditation, or light exercise helps.\n" +
                "\n" +
                "d. Medication Compliance:\n" +
                "If diagnosed, take thyroid medication (like levothyroxine) regularly as prescribed.")
    }
}

@Composable
fun Breast_Cancer(){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp).verticalScroll(scrollState),
        ) {
        Text("Breast Cancer in Girls/Women\n", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Text("How Does it Happen?\n" ,fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Breast cancer happens due to changes (mutations) in the DNA of breast cells. " +
                "These changes can be inherited or occur due to lifestyle and environment.\n")
        Text("Common Causes & Risk Factors:\n", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Family history of breast cancer\n" +
                "\n" +
                "* Hormonal imbalance\n" +
                "\n" +
                "* Early periods or late menopause\n" +
                "\n" +
                "* Unhealthy lifestyle (poor diet, lack of exercise)\n" +
                "\n" +
                "* Obesity\n" +
                "\n" +
                "* Smoking and alcohol\n")
        Text("Prevention Tips:\n", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Do regular self-examination for any lumps or changes\n" +
                "\n" +
                "Go for regular mammograms after age 40 (or earlier if family history)\n" +
                "\n" +
                "Maintain a healthy weight\n" +
                "\n" +
                "Avoid smoking and limit alcohol\n" +
                "\n" +
                "Stay active and eat a balanced diet")
    }
    }


@Composable
fun PCOD(){
    val sc = rememberScrollState()
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp).verticalScroll(sc),
    ) {
        Text("PCOD in Girls/Women\n",fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Text("1. What is PCOD?\n",fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("PCOD (Polycystic Ovarian Disease) is a hormonal disorder where a woman's ovaries " +
                "produce many small cysts (fluid-filled sacs) and excess male hormones (androgens)." +
                " It affects menstrual cycle, fertility, and overall health.\n")
        Text("How Does it Happen?\n",fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("PCOD occurs due to a hormonal imbalance, especially high levels of androgens and " +
                "insulin resistance. The exact cause is not always clear but is often linked to:\n")
        Text("Causes & Risk Factors:\n", fontWeight = FontWeight.Bold)
        Text("Genetics (family history)\n" +
                "\n" +
                "Poor lifestyle (junk food, no exercise)\n" +
                "\n" +
                "Obesity\n" +
                "\n" +
                "Stress\n" +
                "\n" +
                "Hormonal imbalance\n" +
                "\n")
        Text("Common Symptoms:\n" , fontWeight = FontWeight.Bold)
        Text("Irregular or missed periods\n" +
                "\n" +
                "Weight gain, especially around the belly\n" +
                "\n" +
                "Acne or oily skin\n" +
                "\n" +
                "Excess hair growth (face/body)\n" +
                "\n" +
                "Hair thinning on the scalp\n" +
                "\n" +
                "Difficulty getting pregnant\n" +
                "\n")
        Text("Prevention & Management:\n",fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Eat a healthy diet (low sugar, high fiber)\n" +
                "\n" +
                "Do regular exercise (30 min daily)\n" +
                "\n" +
                "Maintain a healthy weight\n" +
                "\n" +
                "Reduce stress with yoga or meditation\n" +
                "\n" +
                "Consult a doctor for treatment if needed (medicines or hormone therapy)")



    }
}

@Composable
fun Infection(){
    val sc = rememberScrollState()
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp).verticalScroll(sc),
    ) {
        Text("Common Infections in Girls/Women\n",fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Text("1. Urinary Tract Infection (UTI):\n",fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("What is it?\n" +
                "An infection in any part of the urinary system (kidneys, bladder, or urethra).\n")
        Text("Symptoms:", fontWeight = FontWeight.Bold)
        Text("Burning while urinating\n" +
                "\n" +
                "Frequent urge to urinate\n" +
                "\n" +
                "Lower belly pain\n" +
                "\n" +
                "Cloudy or smelly urine\n")
        Text("Prevention:", fontWeight = FontWeight.Bold)
        Text("Drink plenty of water\n" +
                "\n" +
                "Wipe from front to back after toilet\n" +
                "\n" +
                "Avoid holding urine for too long\n" +
                "\n" +
                "Maintain hygiene during periods\n")
        Text("Yeast Infection (Candidiasis):\n",fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("What is it?\n" +
                "An overgrowth of a fungus called Candida in the vaginal area.")
        Text("Symptoms:", fontWeight = FontWeight.Bold)
        Text("Itching or burning\n" +
                "\n" +
                "Thick white discharge\n" +
                "\n" +
                "Redness or swelling")
        Text("Prevention", fontWeight = FontWeight.Bold)
        Text("Wear loose cotton underwear\n" +
                "\n" +
                "Avoid using harsh soaps or douches\n" +
                "\n" +
                "Keep the area dry and clean\n")
        Text("Bacterial Vaginosis (BV):\n",fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("What is it?\n" +
                "An imbalance of the natural bacteria in the vagina.")
        Text("Symptoms:", fontWeight = FontWeight.Bold)
        Text("Thin, grey or white discharge\n" +
                "\n" +
                "Fishy smell\n" +
                "\n" +
                "Mild itching or burning")
        Text("Prevention:", fontWeight = FontWeight.Bold)
        Text(
                "Avoid unclean public toilets\n" +
                "\n" +
                "Don’t use scented feminine products\n" +
                "\n" +
                "Practice safe sex")

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PrThyroi(){
   Infection()
}
