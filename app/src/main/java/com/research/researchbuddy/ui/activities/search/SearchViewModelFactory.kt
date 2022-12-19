package com.research.researchbuddy.ui.activities.search

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.research.researchbuddy.api.core.CoreDataSource
import com.research.researchbuddy.api.core.CoreRepository
import com.research.researchbuddy.api.springernature.SpringerNatureDataSource
import com.research.researchbuddy.api.springernature.SpringerNatureRepository
import java.lang.IllegalArgumentException

class SearchViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(
                    springerNatureRepository = SpringerNatureRepository(
                            springerNatureDataSource = SpringerNatureDataSource()
                    ),
                    coreRepository = CoreRepository(
                            coreDataSource = CoreDataSource()
                    )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}