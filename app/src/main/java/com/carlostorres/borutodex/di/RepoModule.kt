package com.carlostorres.borutodex.di

import android.content.Context
import com.carlostorres.borutodex.data.repository.DataStoreOperationsImpl
import com.carlostorres.borutodex.data.repository.Repository
import com.carlostorres.borutodex.domain.repository.DataStoreOperations
import com.carlostorres.borutodex.domain.use_cases.UseCases
import com.carlostorres.borutodex.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.carlostorres.borutodex.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.carlostorres.borutodex.domain.use_cases.save_oboarding.SaveOnBoardingUseCase
import com.carlostorres.borutodex.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ) : DataStoreOperations {
        return DataStoreOperationsImpl(context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository) : UseCases{
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository)
        )
    }

}