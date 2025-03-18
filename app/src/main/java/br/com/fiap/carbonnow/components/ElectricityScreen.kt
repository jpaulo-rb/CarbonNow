package br.com.fiap.carbonnow.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.carbonnow.R

@Composable
fun ElectricityScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(modifier = Modifier.fillMaxSize())
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
    }
    NavBar(navController = navController)
}