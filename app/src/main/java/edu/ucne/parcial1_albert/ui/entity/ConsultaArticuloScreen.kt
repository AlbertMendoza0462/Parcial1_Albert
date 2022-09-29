package edu.ucne.parcial1_albert.ui.entity

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import edu.ucne.parcial1_albert.utils.Screen


@Composable
fun ConsultaArticuloScreen(
    navHostController: NavHostController,
    viewModel: ArticuloViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Consulta de Articulos") }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { navHostController.navigate(Screen.RegistroArticuloScreen.Route) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }

        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(8.dp)
            ) {
                val lista = viewModel.articulos.collectAsState(initial = emptyList())

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        Row() {
                            Text(
                                text = "Id",
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(50.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = "Nombre",
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(100.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = "Marca",
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(100.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = "Exist",
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(70.dp)
                                    .padding(8.dp)
                            )
                        }
                    }
                    items(lista.value) {
                        Row() {
                            Text(
                                text = it.ArticuloId.toString(),
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(50.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = it.Descripcion,
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(100.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = it.Marca,
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(100.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text = it.Existencia.toString(),
                                modifier = Modifier
                                    .border(width = 1.dp, color = Color.Black)
                                    .width(70.dp)
                                    .padding(8.dp)
                            )
                            OutlinedButton(
                                modifier = Modifier.height(35.dp),
                                onClick = { navHostController.navigate(Screen.RegistroArticuloScreen.Route + "/" + it.ArticuloId) }) {
                                Icon(Icons.Default.Edit, contentDescription = "Editar")
                            }
                        }
                    }
                }
            }
        }
    }
}