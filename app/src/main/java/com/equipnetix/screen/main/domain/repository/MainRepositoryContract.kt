package com.equipnetix.screen.main.domain.repository

import com.equipnetix.screen.main.data.model.MainData

interface MainRepositoryContract {
    suspend fun getData(): MainData
}