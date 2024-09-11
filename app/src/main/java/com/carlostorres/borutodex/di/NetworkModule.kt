package com.carlostorres.borutodex.di

import com.carlostorres.borutodex.data.local.BorutoDatabase
import com.carlostorres.borutodex.data.remote.BorutoApi
import com.carlostorres.borutodex.data.repository.RemoteDataSourceImpl
import com.carlostorres.borutodex.domain.repository.RemoteDataSource
import com.carlostorres.borutodex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient() : OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.MINUTES)
            .connectTimeout(15, TimeUnit.MINUTES)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideBorutoApi(
        retrofit: Retrofit
    ) : BorutoApi {
        return retrofit.create(BorutoApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        api: BorutoApi,
        database: BorutoDatabase
    ) : RemoteDataSource = RemoteDataSourceImpl(borutoApi = api, borutoDatabase = database)

}