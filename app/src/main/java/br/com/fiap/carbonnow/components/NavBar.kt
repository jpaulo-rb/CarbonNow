package br.com.fiap.carbonnow.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.carbonnow.R

@Composable
fun NavBar(modifier: Modifier = Modifier, navController: NavController) {
    Box(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .background(color = colorResource(id = R.color.white_yellowish))
                .fillMaxWidth()
                .navigationBarsPadding()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(painter = painterResource(id = R.drawable.cart), contentDescription = "Cart", modifier = Modifier.padding(8.dp).clickable(onClick = {
                navController.navigate("shipping")
            } ))
            Image(painter = painterResource(id = R.drawable.home), contentDescription = "Home", modifier = Modifier.padding(8.dp).clickable(onClick = {
                navController.navigate("home")
            }))
            Image(painter = painterResource(id = R.drawable.battery), contentDescription = "Profile", modifier = Modifier.padding(8.dp).clickable(onClick = {
                navController.navigate("electricity")
            }))
        }
    }
}

