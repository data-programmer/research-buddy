package com.research.researchbuddy.room

import androidx.annotation.WorkerThread
import com.research.researchbuddy.room.dao.FavoriteDao
import com.research.researchbuddy.room.entity.FavoriteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class FavoriteRepository(private val favoriteDao: FavoriteDao) {

    fun getAllFavorites(): Flow<List<FavoriteEntity>> {
        return favoriteDao.getAllFavorites()
    }

    suspend fun addFavorite(favoriteEntity: FavoriteEntity) {
        favoriteDao.addFavorite(favoriteEntity)
    }

    suspend fun updateFavorite(favoriteEntity: FavoriteEntity) {
        favoriteDao.updateFavorite(favoriteEntity)
    }

    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity) {
        favoriteDao.deleteFavorite(favoriteEntity)
    }

}