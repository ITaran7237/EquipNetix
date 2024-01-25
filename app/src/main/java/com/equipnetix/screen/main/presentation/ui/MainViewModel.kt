package com.equipnetix.screen.main.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.equipnetix.base.BaseViewModel
import com.equipnetix.screen.main.data.model.MainData
import com.equipnetix.screen.main.domain.repository.MainUseCase
import com.equipnetix.util.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : BaseViewModel(),
    MainViewModelContract {

    private val _resultState = MutableLiveData<ResultState<MainData>>()
    override val resultState: LiveData<ResultState<MainData>> get() = _resultState

    override fun fetchData() {
        launch {
            _resultState.postValue(ResultState.Loading)
            try {
                val response = mainUseCase.getMainData()
                _resultState.postValue(ResultState.Success(response))
            } catch (e: Exception) {
                _resultState.postValue(ResultState.Error(e.message ?: "An error occurred"))
            }
        }
    }
}