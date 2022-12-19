package com.research.researchbuddy.api.core

import com.research.researchbuddy.models.ApiResult
import com.research.researchbuddy.models.CoreResponse
import java.io.IOException
import java.lang.Exception

class CoreDataSource {

    private val coreApiService: CoreApiService = CoreApiService.invoke()

    suspend fun fetchResearchSearch(
            query: String
    ): ApiResult<CoreResponse> {
        return try {
            val result = coreApiService.searchResearchContentAsync(
                    query
            ).await()
            ApiResult.Success(result)
        } catch (exception: Exception) {
            ApiResult.Error(IOException("Failed to fetch search results", exception))
        }
    }

}