package edu.ucne.parcial1_albert.ui.entity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun ArticuloScreen(
    navHostController: NavHostController,
    viewModel: ArticuloViewModel = hiltViewModel(),
    ArticuloId: String?
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Registro de Articulos") }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .padding(8.dp)
            ) {
                OutlinedTextField(
                    label = { Text(text = "Descripcion") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    value = viewModel.Descripcion,
                    onValueChange = { viewModel.Descripcion = it })
                OutlinedTextField(
                    label = { Text(text = "Marca") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    value = viewModel.Marca,
                    onValueChange = { viewModel.Marca = it })
                OutlinedTextField(
                    label = { Text(text = "Existencia") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    value = viewModel.Existencia.toString(),
                    onValueChange = {
                        viewModel.Existencia = it.toInt()
                    })
                OutlinedButton(
                    onClick = {
                        navHostController.navigateUp()
                        viewModel.Guardar()
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Guardar")
                }
            }
        }
    }
}