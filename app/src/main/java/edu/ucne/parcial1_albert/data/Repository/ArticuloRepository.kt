package edu.ucne.parcial1_albert.data.Repository

import edu.ucne.parcial1_albert.data.dao.ArticuloDao
import edu.ucne.parcial1_albert.data.entity.Articulo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticuloRepository @Inject constructor(
    val articuloDao: ArticuloDao
) {
    suspend fun insert(articulo: Articulo){
        articuloDao.insert(articulo)
    }
    suspend fun delete(articulo: Articulo){
        articuloDao.delete(articulo)
    }
    suspend fun find(ArticuloId: Int): Articulo{
        return articuloDao.find(ArticuloId)
    }
    fun getList(): Flow<List<Articulo>>{
        return articuloDao.getList()
    }
}