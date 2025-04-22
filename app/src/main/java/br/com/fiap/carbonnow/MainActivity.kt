package br.com.fiap.carbonnow

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.carbonnow.components.ConfigScreen
import br.com.fiap.carbonnow.components.ElectricityScreen
import br.com.fiap.carbonnow.components.HomeScreen
import br.com.fiap.carbonnow.components.ItemsScreen
import br.com.fiap.carbonnow.components.LoginScreen
import br.com.fiap.carbonnow.components.OpenedDataScreen
import br.com.fiap.carbonnow.components.ShippingScreen
import br.com.fiap.carbonnow.ui.theme.CarbonNowTheme
import br.com.fiap.carbonnow.viewmodel.ElectricityScreenViewModel
import br.com.fiap.carbonnow.viewmodel.ShippingScreenViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarbonNowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    //CONSTANTE QUE CONTÉM O NAVCONTROLER QUE LEMBRA O ESTADO DE NAVEGAÇÃO
                    val navController = rememberNavController()
                    //NAVHOST RECEVE O NAVCONTROLER QUE LEMBRA AS TELAS QUE FORAM LIDAS
                    NavHost(navController = navController, startDestination = "login"){
                        composable(route = "login"){
                            LoginScreen(navController)
                        }
                        composable(route = "home"){
                            HomeScreen(navController)
                        }
                        composable(route = "config"){
                            ConfigScreen(navController = navController)
                        }
                        composable(route = "items"){
                            ItemsScreen(navController = navController)
                        }
                        composable(route = "openedItem"){
                            OpenedDataScreen(navController = navController)
                        }
                        composable(route = "electricity"){
                            ElectricityScreen(
                                navController = navController,
                                electricityScreenViewModel = ElectricityScreenViewModel()
                            )
                        }
                        composable(route = "shipping"){
                            ShippingScreen(
                                navController = navController,
                                shippingScreenViewModel = ShippingScreenViewModel()
                            )
                        }
                    }
                }
            }
        }
    }
}
