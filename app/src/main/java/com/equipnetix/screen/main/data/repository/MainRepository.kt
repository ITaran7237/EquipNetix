package com.equipnetix.screen.main.data.repository

import com.equipnetix.screen.main.domain.repository.MainRepositoryContract
import javax.inject.Inject

class MainRepository @Inject constructor(private val mainDataSource: MainDataSource) :
    MainRepositoryContract {
    override suspend fun getData() = mainDataSource.getData()
}