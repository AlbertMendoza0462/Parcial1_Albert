package edu.ucne.parcial1_albert.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Articulos")
data class Articulo(
    @PrimaryKey(autoGenerate = true)
    val ArticuloId: Int=0,
    val Descripcion: String="",
    val Marca: String="",
    val Existencia: Double=0.0
)