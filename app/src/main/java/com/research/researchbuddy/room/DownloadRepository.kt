package com.research.researchbuddy.room

import com.research.researchbuddy.room.dao.DownloadDao
import com.research.researchbuddy.room.entity.DownloadEntity
import kotlinx.coroutines.flow.Flow

class DownloadRepository(private val downloadDao: DownloadDao) {

    fun getAllDownloads(): Flow<List<DownloadEntity>> {
        return downloadDao.getAllDownloads()
    }

    suspend fun addDownload(downloadEntity: DownloadEntity) {
        downloadDao.addDownload(downloadEntity)
    }

    suspend fun updateDownload(downloadEntity: DownloadEntity) {
        downloadDao.updateDownload(downloadEntity)
    }

    suspend fun deleteDownload(downloadEntity: DownloadEntity) {
        downloadDao.deleteDownload(downloadEntity)
    }

}