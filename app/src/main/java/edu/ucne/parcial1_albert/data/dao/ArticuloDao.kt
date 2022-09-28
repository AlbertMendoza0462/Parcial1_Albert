package edu.ucne.parcial1_albert.data.dao

import androidx.room.*
import edu.ucne.parcial1_albert.data.entity.Articulo
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticuloDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articulo: Articulo)
    @Delete
    suspend fun delete(articulo: Articulo)
    @Query("SELECT * FROM Articulos WHERE ArticuloId = :ArticuloId LIMIT 1")
    suspend fun find(ArticuloId: Int): Articulo
    @Query("SELECT * FROM Articulos")
    fun getList(): Flow<List<Articulo>>
}