package com.equipnetix.screen.main.data.repository

import com.equipnetix.screen.main.domain.repository.MainRepositoryContract
import javax.inject.Inject

class MainDataSource @Inject constructor(private val remoteDataSource: MainRemoteDataSource) :
    MainRepositoryContract {

    override suspend fun getData() = remoteDataSource.fetchMainData()
}