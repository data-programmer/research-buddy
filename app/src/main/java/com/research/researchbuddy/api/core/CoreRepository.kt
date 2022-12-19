package com.research.researchbuddy.api.core

import com.research.researchbuddy.models.ApiResult
import com.research.researchbuddy.models.CoreResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoreRepository(
        private val coreDataSource: CoreDataSource
) {

    suspend fun getResearchResult(
       query: String
    ): ApiResult<CoreResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext coreDataSource.fetchResearchSearch(
                    query
            )
        }
    }

}