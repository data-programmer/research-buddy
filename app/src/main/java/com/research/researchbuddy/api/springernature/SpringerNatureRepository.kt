package com.research.researchbuddy.api.springernature

import com.research.researchbuddy.models.ApiResult
import com.research.researchbuddy.models.SpringerNatureResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpringerNatureRepository(
    private val springerNatureDataSource: SpringerNatureDataSource
) {

    suspend fun getResearchResult(
        query: String
    ): ApiResult<SpringerNatureResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext springerNatureDataSource.fetchResearchSearch(
                query
            )
        }
    }

}