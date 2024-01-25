package com.equipnetix.di

import android.app.Application
import android.content.Context
import com.equipnetix.network.EquipNetixApiService
import com.equipnetix.network.RetrofitBuilder
import com.equipnetix.screen.main.data.repository.MainDataSource
import com.equipnetix.screen.main.data.repository.MainRemoteDataSource
import com.equipnetix.screen.main.data.repository.MainRepository
import com.equipnetix.screen.main.domain.repository.MainRepositoryContract
import com.equipnetix.screen.main.domain.repository.MainUseCase
import com.equipnetix.screen.main.presentation.ui.MainViewModel
import com.equipnetix.screen.main.presentation.ui.MainViewModelContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideApiService(): EquipNetixApiService {
        return RetrofitBuilder.createApiService()
    }

    @Provides
    @Singleton
    fun provideMainViewModel(mainUseCase: MainUseCase): MainViewModelContract {
        return MainViewModel(mainUseCase)
    }

    @Provides
    @Singleton
    fun provideMainRepository(mainDataSource: MainDataSource): MainRepositoryContract {
        return MainRepository(mainDataSource)
    }

    @Provides
    @Singleton
    fun provideMainDataSource(remoteDataSource: MainRemoteDataSource): MainDataSource {
        return MainDataSource(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideMainUseCase(mainRepository: MainRepositoryContract): MainUseCase {
        return MainUseCase(mainRepository)
    }
}
