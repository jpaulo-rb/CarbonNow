package br.com.fiap.carbonnow.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.carbonnow.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ResourceAsColor")
@Composable
fun ItemsScreen(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(R.color.dark))
    )
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
                    .height(175.dp))
        }
        Row(
            modifier = Modifier.fillMaxWidth().align(Alignment.Center).padding(bottom = 120.dp),
            horizontalArrangement = Arrangement.Absolute.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            OutlinedTextField(
                value = "Search here...",
                //IMPLEMENTAR FUNÇÃO DE BUSCA
                onValueChange = {/*TODO*/},
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.white_yellowish),
                    focusedTextColor = colorResource(id = R.color.dark),
                    unfocusedTextColor = colorResource(id = R.color.dark)
                ),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                        Modifier.padding(start = 23.dp)
                    )
                }
            )
        }
    }
    NavBar(navController = navController)
}

@Preview (showSystemUi = true, showBackground = true)
@Composable
private fun ItemsScreenPreview() {
    ItemsScreen(navController = NavController(context = LocalContext.current))
}