package com.research.researchbuddy.api.springernature

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.research.researchbuddy.Constants
import com.research.researchbuddy.api.utilities.SpringerNatureGsonDeserializer
import com.research.researchbuddy.models.SpringerNatureResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * "http://api.springer.com/openaccess/json
 * ?api_key=cd85431633c69e4ae13b57e228b031f6
 * &q=keyword%3Asaturn+and+language%3Aen
 * &s=1
 * &p=10"
 */

interface SpringerNatureApiService {

    @GET("json")
    fun searchResearchContentAsync(
            @Query(value = "q") query: String,
            @Query(value = "s") startingResult: Int = 1,
            @Query(value = "p") numberOfResults: Int = 20
    ): Deferred<SpringerNatureResponse>

    companion object {
        operator fun invoke(): SpringerNatureApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                        .url
                        .newBuilder()
                        .addQueryParameter("api_key", Constants.ApiKeys.SPRINGER_NATURE_KEY)
                        .build()

                val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    //.addInterceptor(ConnectivityInterceptor(this))
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.WebServices.SPRINGER_NATURE_BASE_PATH)
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(
                            GsonConverterFactory.create(
                                    GsonBuilder()
                                            .registerTypeAdapter(
                                                    SpringerNatureResponse::class.java,
                                                    SpringerNatureGsonDeserializer()
                                            )
                                            .create()
                            )
                    )
                    .build()
                    .create(SpringerNatureApiService::class.java)
        }
    }

}