package br.com.fiap.carbonnow.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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

@SuppressLint("ResourceAsColor")
@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(R.color.dark)))
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        {
            Button(
                modifier = Modifier.shadow(8.dp).width(120.dp).height(100.dp), shape = RoundedCornerShape(8.dp),
                //ADICIONAR LOGICA DE ABRIR TELA DE ADICIONAR ITEM
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.white_yellowish)
                ),
            ) {
                Image(painter = painterResource(id = R.drawable.soma), contentDescription = "Imagem de adicionar")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Latest Items", style = TextStyle(Color.White, fontSize = 36.sp))
        }
        //ADICIONAR DATAGRID
    }
    NavBar(navController = navController)
}

@Preview (showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = NavController(context = LocalContext.current))
}