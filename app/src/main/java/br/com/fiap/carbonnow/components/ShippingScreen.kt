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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import br.com.fiap.carbonnow.model.Shipping
import br.com.fiap.carbonnow.service.calcShpping
import br.com.fiap.carbonnow.viewmodel.ShippingScreenViewModel
import java.math.BigDecimal

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ResourceAsColor")
@Composable
fun ShippingScreen(navController: NavController, shippingScreenViewModel: ShippingScreenViewModel) {

    val distanceValue by shippingScreenViewModel.distance_value.observeAsState(initial = 0)
    val weightValue by shippingScreenViewModel.weight_value.observeAsState(initial = 0)
    val transport_method by shippingScreenViewModel.transport_method.observeAsState(initial = "")
    val carbon_g by shippingScreenViewModel.carbon_g.observeAsState(initial = 0)
    val carbon_kg by shippingScreenViewModel.carbon_kg.observeAsState(initial = 0)
    val carbon_lb by shippingScreenViewModel.carbon_lb.observeAsState(initial = 0)
    val carbon_mt by shippingScreenViewModel.carbon_mt.observeAsState(initial = 0)

    var errorTransport by remember { mutableStateOf(false)}

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
        Column(modifier = Modifier.align(Alignment.Center).padding(top = 160.dp)) {
            Text(text = "Shipping distance", style = TextStyle(fontSize = 18.sp), color = Color.White, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            OutlinedTextField(
                suffix = { Text(text = "Km") },
                value = "$distanceValue",
                onValueChange = {
                    shippingScreenViewModel.onDistanceValueChange(BigDecimal(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.white_yellowish),
                    unfocusedTextColor = colorResource(id = R.color.dark)
                ),
                modifier = Modifier.shadow(8.dp, RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Shipping weight", style = TextStyle(fontSize = 18.sp), color = Color.White, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            OutlinedTextField(
                suffix = { Text(text = "Kg") },
                value = "$weightValue",
                onValueChange = {
                    shippingScreenViewModel.onWeightValueChange(BigDecimal(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.white_yellowish),
                    unfocusedTextColor = colorResource(id = R.color.dark)
                ),
                modifier = Modifier.shadow(8.dp, RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Transport method", style = TextStyle(fontSize = 18.sp), color = Color.White, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            OutlinedTextField(
                value = transport_method,
                isError = errorTransport,
                onValueChange = {
                    errorTransport = false
                    shippingScreenViewModel.onTransportMethodValueChange(it)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.white_yellowish),
                    unfocusedTextColor = colorResource(id = R.color.dark)
                ),
                modifier = Modifier.shadow(8.dp, RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(12.dp)){
                if(errorTransport) {
                    Text(text = "Opções disponíveis: ship, train, truck ou plane")
                }

                Text(text = "Carbon G - $carbon_g", style = TextStyle(fontSize = 18.sp), color = Color.White)
                Text(text = "Carbon Kg - $carbon_kg", style = TextStyle(fontSize = 18.sp), color = Color.White)
                Text(text = "Carbon Lb - $carbon_lb", style = TextStyle(fontSize = 18.sp), color = Color.White)
                Text(text = "Carbon Mt - $carbon_mt", style = TextStyle(fontSize = 18.sp), color = Color.White)
            }
            Button(
                modifier = Modifier
                .shadow(8.dp, RoundedCornerShape(128.dp))
                .width(120.dp)
                .height(40.dp)
                .align(alignment = Alignment.CenterHorizontally), shape = RoundedCornerShape(128.dp), colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.white_blue)),
                onClick = {
                    if (
                        transport_method.trim().lowercase() == "ship" ||
                        transport_method.trim().lowercase() == "train" ||
                        transport_method.trim().lowercase() == "truck" ||
                        transport_method.trim().lowercase() == "plane"
                    )
                    {
                        val shipping = Shipping()
                        shipping.weight_value = BigDecimal("$weightValue")
                        shipping.distance_value = BigDecimal("$distanceValue")
                        shipping.transport_method = transport_method

                        calcShpping(shipping, shippingScreenViewModel)
                    } else {
                        errorTransport = true
                    }
                }
            ) {
                Text(text = "Send", style = TextStyle(fontSize = 20.sp))
            }
        }
    }
    NavBar(navController = navController)
}


@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun ShippingScreenPreview() {
    ShippingScreen(navController = NavController(LocalContext.current), shippingScreenViewModel = ShippingScreenViewModel())

}