package edu.ucne.parcial1_albert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial1_albert.ui.entity.ArticuloScreen
import edu.ucne.parcial1_albert.ui.entity.ConsultaArticuloScreen
import edu.ucne.parcial1_albert.ui.theme.Parcial1_AlbertTheme
import edu.ucne.parcial1_albert.utils.Screen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_AlbertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.ConsultaArticuloScreen.Route) {
                        composable(route = Screen.ConsultaArticuloScreen.Route) {
                            ConsultaArticuloScreen(navHostController = navController)
                        }
                        composable(route = Screen.RegistroArticuloScreen.Route + "/{id}") {navEntry ->
                            val id = navEntry.arguments?.getString("id") ?: "0"
                            ArticuloScreen(navHostController = navController, ArticuloId = id)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Parcial1_AlbertTheme {
        Greeting("Android")
    }
}