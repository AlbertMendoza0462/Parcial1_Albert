package edu.ucne.parcial1_albert.data

import androidx.room.Database
import edu.ucne.parcial1_albert.data.entity.Entity
import androidx.room.RoomDatabase

@Database(
    entities = [
        Entity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    //abstract val entityDao: EntityDao
}