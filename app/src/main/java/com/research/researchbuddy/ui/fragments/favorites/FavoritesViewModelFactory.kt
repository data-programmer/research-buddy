package com.research.researchbuddy.ui.fragments.favorites

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.research.researchbuddy.room.FavoriteRepository
import com.research.researchbuddy.room.ResearchBuddyDatabase
import java.lang.IllegalArgumentException

class FavoritesViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            return FavoritesViewModel(
                    favoriteRepository = FavoriteRepository(
                            favoriteDao = ResearchBuddyDatabase.getInstance(context).favoriteDao()
                    )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}