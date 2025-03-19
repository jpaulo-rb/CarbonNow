package br.com.fiap.carbonnow.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.carbonnow.R
import br.com.fiap.carbonnow.model.Electricity
import br.com.fiap.carbonnow.service.calcElectricity
import br.com.fiap.carbonnow.viewmodel.ElectricityScreenViewModel
import java.math.BigDecimal

@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElectricityScreen(modifier: Modifier = Modifier, navController: NavController, electricityScreenViewModel: ElectricityScreenViewModel) {

    val electricityValue by electricityScreenViewModel.electricity_value.observeAsState(initial = 0)
    val carbon_g by electricityScreenViewModel.carbon_g.observeAsState(initial = 0)
    val carbon_kg by electricityScreenViewModel.carbon_kg.observeAsState(initial = 0)
    val carbon_lb by electricityScreenViewModel.carbon_lb.observeAsState(initial = 0)
    val carbon_mt by electricityScreenViewModel.carbon_mt.observeAsState(initial = 0)

    Box(modifier = Modifier.fillMaxSize().background(Color(R.color.dark)))
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp), Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo da empresa",
                modifier = Modifier
                    .width(280.dp)
                    .height(175.dp)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 32.dp, start = 16.dp, bottom = 32.dp, end = 16.dp)
        ) {
            Text(text = "Energy Consumption", color = Color.White , style = TextStyle(fontSize = 20.sp), modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            OutlinedTextField(
                suffix = { Text(text = "mHw")},
                value = "$electricityValue",
                onValueChange = {
                    electricityScreenViewModel.onElectricityValueChange(BigDecimal(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.white_yellowish),
                    unfocusedTextColor = colorResource(id = R.color.dark)
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.shadow(8.dp, RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = "Carbon G - $carbon_g", style = TextStyle(fontSize = 20.sp), color = Color.White)
                Text(text = "Carbon Kg - $carbon_kg", style = TextStyle(fontSize = 20.sp), color = Color.White)
                Text(text = "Carbon Lb - $carbon_lb", style = TextStyle(fontSize = 20.sp), color = Color.White)
                Text(text = "Carbon Mt - $carbon_mt", style = TextStyle(fontSize = 20.sp), color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(128.dp))
                    .width(120.dp)
                    .height(40.dp)
                    .align(alignment = Alignment.CenterHorizontally), shape = RoundedCornerShape(128.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.white_blue)
                ), onClick = {
                    val electricity = Electricity()
                    electricity.electricity_value = BigDecimal("$electricityValue")

                    calcElectricity(electricity, electricityScreenViewModel)
                }) {
                Text(text = "Send", style = TextStyle(fontSize = 20.sp))
            }
        }
    }
    NavBar(navController = navController)
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun ElectricityScreenPreview() {
    ElectricityScreen(navController = NavController(LocalContext.current), electricityScreenViewModel = ElectricityScreenViewModel())
}