package com.research.researchbuddy.ui.fragments.favorites

import androidx.lifecycle.*
import com.research.researchbuddy.room.FavoriteRepository
import kotlinx.coroutines.launch
import com.research.researchbuddy.room.entity.FavoriteEntity

class FavoritesViewModel(private val favoriteRepository: FavoriteRepository) : ViewModel() {

    val favorites: LiveData<List<FavoriteEntity>> = favoriteRepository.getAllFavorites().asLiveData()

    fun deleteFavorite(favoriteEntity: FavoriteEntity) {
        viewModelScope.launch {
            favoriteRepository.deleteFavorite(favoriteEntity)
        }
    }

}