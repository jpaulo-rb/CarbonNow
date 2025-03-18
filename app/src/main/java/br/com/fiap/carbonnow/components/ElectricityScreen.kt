package br.com.fiap.carbonnow.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ElectricityScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(modifier = Modifier.fillMaxSize())
    {

    }
    NavBar(navController = navController)
}