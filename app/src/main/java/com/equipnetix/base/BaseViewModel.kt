package com.equipnetix.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        handleException(throwable)
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO + exceptionHandler

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    private fun handleException(throwable: Throwable) {
        println(">>> throwable.localizedMessage = ${throwable.localizedMessage}")
    }
}