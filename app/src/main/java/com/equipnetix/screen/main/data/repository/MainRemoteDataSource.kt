package com.equipnetix.screen.main.data.repository

import com.equipnetix.network.EquipNetixApiService
import com.equipnetix.screen.main.data.model.MainData
import javax.inject.Inject

class MainRemoteDataSource @Inject constructor(private val apiService: EquipNetixApiService) {

    suspend fun fetchMainData(): MainData {
        return apiService.getCommonData()
    }
}