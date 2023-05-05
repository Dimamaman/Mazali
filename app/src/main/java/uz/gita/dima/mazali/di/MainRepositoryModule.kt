package uz.gita.dima.mazali.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.dima.mazali.domain.MainRepository
import uz.gita.dima.mazali.domain.impl.MainRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface MainRepositoryModule {

    @Binds
    fun getMainRepository(impl: MainRepositoryImpl): MainRepository
}