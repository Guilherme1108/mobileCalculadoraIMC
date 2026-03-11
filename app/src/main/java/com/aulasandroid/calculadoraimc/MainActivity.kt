package com.aulasandroid.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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

        var resultImc by remember {
            mutableStateOf(0.0) }

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
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(8.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Seus dados",
                        fontSize = 24.sp,
                        color = Color(74, 158, 182, 255),
                        fontWeight = FontWeight.Bold
                    )

                    var altura by remember {
                        mutableStateOf("")
                    }

                    var peso by remember {
                        mutableStateOf("")
                    }

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = colorResource(R.color.cor_app),
                                shape = RoundedCornerShape(16.dp),
                            ),
                        value = altura,
                        onValueChange = { novoValor ->
                            altura = novoValor
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = {
                            Text(text = "Altura (cm)")
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent, // Remove ao focar
                            unfocusedIndicatorColor = Color.Transparent, // Remove sem foco
                            disabledIndicatorColor = Color.Transparent, // Remove se desabilitado
                        )
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = colorResource(R.color.cor_app),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        value = peso,
                        onValueChange = { novoValor ->
                            peso = novoValor
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = {
                            Text(text = "Peso (kg)")
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent, // Remove ao focar
                            unfocusedIndicatorColor = Color.Transparent, // Remove sem foco
                            disabledIndicatorColor = Color.Transparent // Remove se desabilitado
                        )
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            val alturaEmMetros = altura.toDouble() / 100
                            resultImc = peso.toDouble() / (alturaEmMetros * alturaEmMetros)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.cor_app),
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = "Calcular",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {
                                altura = ""
                                peso = ""
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(159, 45, 45, 255),
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = "Limpar Dados",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                }
            }
        }

        var corBackgroundResultado by remember {
            mutableStateOf(Color(255,255,255))
        }

        //Card-Resultado
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)) {
            Card(modifier = Modifier
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = corBackgroundResultado
                ),
                elevation = CardDefaults.cardElevation(8.dp),
            ) {
                Row(modifier = Modifier
                    .height(75.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Text(
                    text = "${"%.1f".format(resultImc)}",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    var menssagem = ""

                    if (resultImc < 18.5) {
                        menssagem = "Abaixo do peso"
                        corBackgroundResultado = Color(182, 40, 40, 255)

                    } else if (resultImc >= 18.5 && resultImc < 25) {
                        menssagem = "Peso ideal"
                        corBackgroundResultado = Color(45, 150, 41, 255)

                    } else if (resultImc >= 25 && resultImc < 30) {
                        menssagem = "Levemente acima do peso"
                        corBackgroundResultado = Color(197, 98, 33, 255)

                    } else if (resultImc >= 30 && resultImc < 35) {
                        menssagem = "Obesidade grau |"
                        corBackgroundResultado = Color(182, 40, 40, 255)

                    } else if (resultImc >= 35 && resultImc < 40) {
                        menssagem = "Obesidade grau ||"
                        corBackgroundResultado = Color(182, 40, 40, 255)

                    } else {
                        menssagem = "Obesidade grau |||"
                        corBackgroundResultado = Color(182, 40, 40, 255)
                    }

                    Text(
                        text = menssagem,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }

    }



}

