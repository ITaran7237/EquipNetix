package com.equipnetix.screen.main.domain.repository

import javax.inject.Inject

class MainUseCase @Inject constructor(private val repository: MainRepositoryContract) {
    suspend fun getMainData() = repository.getData()
}