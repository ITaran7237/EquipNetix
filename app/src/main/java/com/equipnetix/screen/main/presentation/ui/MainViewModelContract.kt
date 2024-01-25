package com.equipnetix.screen.main.presentation.ui

import androidx.lifecycle.LiveData
import com.equipnetix.screen.main.data.model.MainData
import com.equipnetix.util.ResultState

interface MainViewModelContract {
    val resultState: LiveData<ResultState<MainData>>
    fun fetchData()
}