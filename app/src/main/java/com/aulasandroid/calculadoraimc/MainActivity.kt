package com.aulasandroid.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IMCScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun IMCScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(color = colorResource(R.color.cor_app)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.bmi),
                contentDescription = "IMC Icon",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
            )

            Text(
                text = "Calculadora de IMC",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        // Card-Formulario
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)) {
            Card(
                modifier = Modifier
                    .offset(y = (-30).dp)
                    .fillMaxWidth()
                    .height(300.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(106, 87, 185, 255)
                ),
                elevation = CardDefaults.cardElevation(8.dp),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Seus dados",
                        fontSize = 24.sp,
                        color = Color(74, 158, 182, 255)
                    )

//                    TextField()
                }
            }
        }

        Row() { }

        //Card-Resultado
        Row() { }

    }



}

