package edu.ucne.parcial1_albert.ui.entity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_albert.data.Repository.ArticuloRepository
import edu.ucne.parcial1_albert.data.entity.Articulo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticuloViewModel @Inject constructor(
    val articuloRepository: ArticuloRepository
) : ViewModel() {
    var ArticuloId by mutableStateOf(0)
    var Descripcion by mutableStateOf("")
    var Marca by mutableStateOf("")
    var Existencia by mutableStateOf(0.0)
    var articulos = articuloRepository.getList()
        private set

    fun Guardar() {
        viewModelScope.launch {
            articuloRepository.insert(
                Articulo(
                    ArticuloId = ArticuloId,
                    Descripcion = Descripcion,
                    Marca = Marca,
                    Existencia = Existencia,
                )
            )
        }
    }
}