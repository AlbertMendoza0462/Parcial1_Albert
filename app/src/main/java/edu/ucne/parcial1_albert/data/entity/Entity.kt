package edu.ucne.parcial1_albert.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Entityes")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val EntityId: Int=0,
    val Nombre: String=""
)