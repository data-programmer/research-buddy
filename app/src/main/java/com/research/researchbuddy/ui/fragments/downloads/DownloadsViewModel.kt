package com.research.researchbuddy.ui.fragments.downloads

import androidx.lifecycle.*
import com.research.researchbuddy.room.DownloadRepository
import com.research.researchbuddy.room.entity.DownloadEntity
import kotlinx.coroutines.launch

class DownloadsViewModel(private val downloadRepository: DownloadRepository) : ViewModel() {

    val downloads: LiveData<List<DownloadEntity>> = downloadRepository.getAllDownloads().asLiveData()

    fun deleteDownload(downloadEntity: DownloadEntity) {
        viewModelScope.launch {
            downloadRepository.deleteDownload(downloadEntity)
        }
    }

}