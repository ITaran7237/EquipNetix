package com.equipnetix.di

import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent