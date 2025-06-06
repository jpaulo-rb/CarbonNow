package br.com.fiap.carbonnow.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.carbonnow.R



@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@SuppressLint("ResourceAsColor")
@Composable
fun LoginScreen(navController: NavController) {
            Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(R.color.dark)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 130.dp)
        ) {
            Text(text = "User", color = Color.White, style = TextStyle(fontSize = 20.sp))
            OutlinedTextField(
                modifier = Modifier.shadow(8.dp, RoundedCornerShape(148.dp)),
                value = "Type here...",
                onValueChange = {},
                shape = RoundedCornerShape(148.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.white_yellowish),
                    unfocusedTextColor = colorResource(id = R.color.dark)
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Password", color = Color.White, style = TextStyle(fontSize = 20.sp))
            OutlinedTextField(
                modifier = Modifier.shadow(8.dp, RoundedCornerShape(148.dp)),
                value = "Type here...",
                onValueChange = {},
                shape = RoundedCornerShape(148.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.white_yellowish),
                    unfocusedTextColor = colorResource(id = R.color.dark)
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                modifier = Modifier.shadow(8.dp, RoundedCornerShape(148.dp)).width(120.dp).height(40.dp),
                onClick = {
                    navController.navigate("home")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.white_blue)
                ),
            ) {
                Text(text = "Login", style = TextStyle(fontSize = 20.sp))
            }
        }
    }

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
}

@Preview (showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = NavController(context = LocalContext.current))
}