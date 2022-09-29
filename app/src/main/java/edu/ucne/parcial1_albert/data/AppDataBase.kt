package edu.ucne.parcial1_albert.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_albert.data.dao.ArticuloDao
import edu.ucne.parcial1_albert.data.entity.Articulo

@Database(
    entities = [
        Articulo::class
    ],
    version = 3,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract val articuloDao: ArticuloDao
}