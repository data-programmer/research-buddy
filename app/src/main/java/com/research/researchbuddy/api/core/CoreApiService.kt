package com.research.researchbuddy.api.core

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.research.researchbuddy.Constants
import com.research.researchbuddy.models.CoreResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *  articles/search/
 *  venus?
 *  page=1&
 *  pageSize=1&
 *  metadata=true&
 *  fulltext=false&
 *  citations=false&
 *  similar=false&
 *  duplicate=false&
 *  urls=false&
 *  faithfulMetadata=false&
 *  apiKey=nyVNY7w1dTkP4cesGOEIF0aBqKrZ2v9i
 */

interface CoreApiService {

    @GET("{query}")
    fun searchResearchContentAsync(
            @Path(value = "query") query: String,
            @Query(value = "page") startingResult: Int = 1,
            @Query(value = "pageSize") startingSizeResult: Int = 20,
            @Query(value = "metadata") metadataResult: Boolean = true,
            @Query(value = "fulltext") fulltextResult: Boolean = false,
            @Query(value = "citations") citationResult: Boolean = false,
            @Query(value = "similar") similarResult: Boolean = false,
            @Query(value = "duplicate") duplicateResult: Boolean = false,
            @Query(value = "urls") urlsResult: Boolean = false,
            @Query(value = "faithfulMetadata") faithfulMetadataResult: Boolean = false
    ): Deferred<CoreResponse>

    companion object {
        operator fun invoke(): CoreApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                        .url
                        .newBuilder()
                        .addQueryParameter("apiKey", Constants.ApiKeys.CORE_KEY)
                        .build()

                val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    // .addInterceptor(ConnectivityInterceptor(this)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.WebServices.CORE_BASE_PATH)
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CoreApiService::class.java)
        }
    }

}