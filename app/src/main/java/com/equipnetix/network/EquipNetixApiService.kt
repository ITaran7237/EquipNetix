package com.equipnetix.network

import com.equipnetix.screen.main.data.model.MainData
import retrofit2.http.GET

interface EquipNetixApiService {

    @GET("/random_joke")
    suspend fun getCommonData(): MainData
}