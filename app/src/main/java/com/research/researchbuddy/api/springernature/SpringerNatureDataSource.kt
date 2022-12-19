package com.research.researchbuddy.api.springernature

import com.research.researchbuddy.api.utilities.exceptions.NoConnectivityException
import com.research.researchbuddy.models.ApiResult
import com.research.researchbuddy.models.SpringerNatureResponse
import java.io.IOException

class SpringerNatureDataSource {

    private val springerNatureApiService: SpringerNatureApiService = SpringerNatureApiService.invoke()

    suspend fun fetchResearchSearch(
        query: String
    ): ApiResult<SpringerNatureResponse> {
        return try {
            val result = springerNatureApiService.searchResearchContentAsync(
                    query
            ).await()
            ApiResult.Success(result)
        } catch (exception: NoConnectivityException) {
            ApiResult.Error(IOException("Failed to fetch search results", exception))
        }
    }

}