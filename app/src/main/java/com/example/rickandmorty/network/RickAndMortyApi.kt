package com.example.rickandmorty.network

import com.example.rickandmorty.models.CharacterModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/api"

interface RickAndMortyApi {

    @GET("/character")
    fun getAllCharacters(): CharacterModel



}

val retrofit = Retrofit
    .Builder()
    .client(
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also{
            it.level = HttpLoggingInterceptor.Level.BODY
        }).build()
    )
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
    .create(RickAndMortyApi::class.java)
