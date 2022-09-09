package com.cherish.apimodule.di

import com.cherish.apimodule.domain.MilkyWayUseCases
import com.cherish.apimodule.domain.MilkyWayUseCasesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun provideMilkyWayUseCase(milkyWayUseCases: MilkyWayUseCasesImpl): MilkyWayUseCases
}