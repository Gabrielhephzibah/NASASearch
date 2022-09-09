package com.cherish.apimodule.common

sealed class Resource<out T>(
    val data : T? = null,
    val error : Throwable? = null,
     val loading: Boolean? = true
) {
    class Loading(state: Boolean? = true): Resource<Nothing>(loading = state)
    class Error(error: Throwable? = null): Resource<Nothing>(error = error)
    class Success<T>(data: T): Resource<T>(data = data)
}