package br.com.fiap.carbonnow.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.carbonnow.R

@SuppressLint("ResourceAsColor")
@Composable
fun ConfigScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(modifier= Modifier.background(Color(R.color.dark)).fillMaxSize())
    {
        Column(
            modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "Logo da empresa")
            Text(text = "User", style = TextStyle(Color.White, fontSize = 36.sp))
        }
        Column(modifier = Modifier.align(Alignment.CenterStart).padding(start = 15.dp), verticalArrangement = Arrangement.Center)
        {
            //ADICIONAR ONCLICK PARA CADA ITEM
            Text(
                text = "List all items",
                style = TextStyle(Color.White, fontSize = 24.sp),
                modifier = Modifier.padding(8.dp).clickable {
                    navController.navigate("items")
                }
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Text(
                text = "Change Theme",
                style = TextStyle(Color.White, fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Text(
                text = "Change Password",
                style = TextStyle(Color.White, fontSize = 24.sp)
            )
        }
    }
    NavBar(navController = navController)
}

//@Preview (showSystemUi = true, showBackground = true)
//@Composable
//private fun ConfigScreenPreview() {
//    ConfigScreen()
//
//}