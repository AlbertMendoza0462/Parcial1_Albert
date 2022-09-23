package edu.ucne.parcial1_albert.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcial1_albert.data.AppDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvideTicketDb(@ApplicationContext context: Context): AppDataBase {
        val DATABASE_NAME = "parcial1_albert.db"
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

//    @Provides
//    fun ProvideEntityDAO(appDataBase: AppDataBase): EntityDao {
//        return appDataBase.entityDao
//    }
//
//    @Provides
//    fun provideEntityRepository(entityDao: EntityDao): EntityRepository {
//        return EntityRepository(entityDao)
//    }
}