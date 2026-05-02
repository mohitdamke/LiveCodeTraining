package com.mohit.machinecoding.di

import com.mohit.machinecoding.data.remote.WeatherApi
import com.mohit.machinecoding.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi{

        return retrofit.create(WeatherApi::class.java)

    }

    @Provides
    @Singleton
    fun provideRepository(api : WeatherApi): WeatherRepository{

        return WeatherRepository(api)

    }









}