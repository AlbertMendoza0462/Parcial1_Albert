package edu.ucne.parcial1_albert.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_albert.data.entity.Entity

@Database(
    entities = [
        Entity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    //abstract val entityDao: EntityDao
}