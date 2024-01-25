package com.equipnetix.util

sealed class ResultState<out T> {

    data class Success<T>(val data: T) : ResultState<T>()

    data class Error(val errorMessage: String) : ResultState<Nothing>()

    data object Loading : ResultState<Nothing>()
}