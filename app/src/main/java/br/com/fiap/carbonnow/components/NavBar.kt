package br.com.fiap.carbonnow.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.carbonnow.R

@Composable
fun NavBar(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .background(color = colorResource(id = R.color.white_yellowish))
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(painter = painterResource(id = R.drawable.cart), contentDescription = "Cart")
            Image(painter = painterResource(id = R.drawable.home), contentDescription = "Home")
            Image(painter = painterResource(id = R.drawable.battery), contentDescription = "Profile")
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
private fun NavBarPreview() {
    NavBar()
}