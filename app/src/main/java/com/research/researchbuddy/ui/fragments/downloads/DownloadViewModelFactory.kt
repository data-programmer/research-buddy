package com.research.researchbuddy.ui.fragments.downloads

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.research.researchbuddy.room.DownloadRepository
import com.research.researchbuddy.room.ResearchBuddyDatabase
import java.lang.IllegalArgumentException

class DownloadViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DownloadsViewModel::class.java)) {
            return DownloadsViewModel(
                    downloadRepository = DownloadRepository(
                            downloadDao = ResearchBuddyDatabase.getInstance(context).downloadDao()
                    )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}