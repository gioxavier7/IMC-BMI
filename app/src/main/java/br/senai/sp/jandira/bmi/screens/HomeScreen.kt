package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun HomeScreen(controleDeNavegacao: NavHostController?) {

    var nomeState = remember {
        mutableStateOf(value = "")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                listOf(
                    Color(0xff29DBD8),
                    Color(0xff141A6B)
                )
            ))
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = painterResource(R.drawable.exercise),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier
                    .padding(vertical = 55.dp)
            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 55.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .height(150.dp),
                shape = RoundedCornerShape(
                    topStart = 48.dp,
                    topEnd = 48.dp
                )

            ){
                Column(
                    modifier = Modifier
                        .padding(22.dp)
                        .fillMaxSize()
                        .padding(bottom = 50.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    Column(
                        modifier = Modifier
                            .padding(28.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        OutlinedTextField(
                            value = nomeState.value,
                            onValueChange = {
                                nomeState.value = it
                            },
                            label = {
                                Text(text = "Digite o seu nome.",
                                    fontSize = 13.sp)
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "",
                                    tint = Color(0xFF141A6B)
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "",
                                    tint = Color(0xFF141A6B)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Words
                            )

                        )
                    }
                    Button(onClick = {
                        controleDeNavegacao?.navigate("user_data")
                    },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF141A6B))) {
                        Text(
                            text = stringResource(R.string.next),
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(null)
}