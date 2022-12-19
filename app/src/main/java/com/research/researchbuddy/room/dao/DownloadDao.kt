package com.research.researchbuddy.room.dao

import androidx.room.*
import com.research.researchbuddy.room.entity.DownloadEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DownloadDao {

    @Query("select * from Downloads")
    fun getAllDownloads(): Flow<List<DownloadEntity>>

    @Insert
    suspend fun addDownload(downloadEntity: DownloadEntity)

    @Update
    suspend fun updateDownload(downloadEntity: DownloadEntity)

    @Delete
    suspend fun deleteDownload(downloadEntity: DownloadEntity)

}