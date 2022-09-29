package edu.ucne.parcial1_albert.ui.entity

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController


@Composable
fun ArticuloScreen(
    navHostController: NavHostController,
    viewModel: ArticuloViewModel = hiltViewModel(),
    ArticuloId: Int = 0
) {
    val context = LocalContext.current
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
                    onValueChange = {
                        viewModel.Descripcion = it
                    })
                OutlinedTextField(
                    label = { Text(text = "Marca") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    value = viewModel.Marca,
                    onValueChange = {
                        viewModel.Marca = it
                    })
                OutlinedTextField(
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Existencia") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    value = viewModel.Existencia.toString(),
                    onValueChange = {
                        try {
                            it.toDouble()
                            if (it.contains('.') && !it.contains('-')) {
                                viewModel.Existencia = it.toDouble()
                            }
                        } catch (_: Exception) {
                        }
                    })
                OutlinedButton(
                    onClick = {
                        if (viewModel.Descripcion.isBlank())
                            Toast.makeText(
                                context,
                                "La descripcion no puede estar vacia",
                                Toast.LENGTH_SHORT
                            ).show()
                        else if (viewModel.Marca.isBlank())
                            Toast.makeText(
                                context,
                                "La marca no puede estar vacia",
                                Toast.LENGTH_SHORT
                            ).show()
                        else if (viewModel.Existencia < 0)
                            Toast.makeText(
                                context,
                                "La existencia no puede ser menor que 0",
                                Toast.LENGTH_SHORT
                            ).show()
                        else {
                            viewModel.Guardar()
                            navHostController.navigateUp()
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Guardar")
                }
            }
        }
    }
}