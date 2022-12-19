package com.research.researchbuddy.room.dao

import androidx.room.*
import com.research.researchbuddy.room.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("select * from Favorites")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    @Insert
    suspend fun addFavorite(favoriteEntity: FavoriteEntity)

    @Update
    suspend fun updateFavorite(favoriteEntity: FavoriteEntity)

    @Delete
    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity)

}