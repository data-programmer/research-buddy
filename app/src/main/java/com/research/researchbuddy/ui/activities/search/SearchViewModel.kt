package com.research.researchbuddy.ui.activities.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.research.researchbuddy.api.core.CoreRepository
import com.research.researchbuddy.api.springernature.SpringerNatureRepository
import com.research.researchbuddy.api.utilities.CoreResponseParser
import com.research.researchbuddy.api.utilities.SpringerNatureResponseParser
import com.research.researchbuddy.models.ApiResult
import com.research.researchbuddy.models.CoreResponse
import com.research.researchbuddy.models.Paper
import com.research.researchbuddy.models.SpringerNatureResponse
import kotlinx.coroutines.launch
import java.io.IOException

class SearchViewModel(
        private val springerNatureRepository: SpringerNatureRepository,
        private val coreRepository: CoreRepository
): ViewModel() {

    var searchProvider = ""
    var searchBy = ""
    var searchText = ""

    private val _researchSearchResult = MutableLiveData<List<Paper>>()
    val researchSearchResult: LiveData<List<Paper>> = _researchSearchResult

    fun fetchResearchSearchResult() {
        viewModelScope.launch {
            val result = when (searchProvider) {
                "Springer Nature" -> { searchSpringerNature() }
                "CORE" -> { searchCore() }
                else -> { ApiResult.Error(IOException("Unknown data source")) }
            }

            if (result is ApiResult.Success) {
                val data = result.data
                val parsedResultList = when (searchProvider) {
                    "Springer Nature" -> { SpringerNatureResponseParser.parseResponseObject(data as SpringerNatureResponse) }
                    "CORE" -> { CoreResponseParser.parseResponseObject(data as CoreResponse) }
                    else -> { listOf() }
                }

                _researchSearchResult.postValue(parsedResultList)
            } else {
                _researchSearchResult.postValue(listOf())
            }
        }
    }

    private suspend fun searchSpringerNature(): ApiResult<SpringerNatureResponse> {
        return springerNatureRepository.getResearchResult(buildSpringerNatureQuery())
    }

    private suspend fun searchCore(): ApiResult<CoreResponse> {
        return coreRepository.getResearchResult(buildCoreQuery())
    }

    private fun buildSpringerNatureQuery(): String  = "keyword:$searchText"

    private fun buildCoreQuery(): String = "$searchText"

}