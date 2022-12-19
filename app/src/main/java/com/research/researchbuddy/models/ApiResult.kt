package com.research.researchbuddy.models

import kotlin.jvm.Throws

sealed class ApiResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }

    companion object ResultException {
        @Throws
        fun throwExceptionIfError(apiResult: ApiResult<Any>?) {
            if (apiResult == null)
                return

            if (apiResult is Error)
                throw apiResult.exception
        }
    }

}