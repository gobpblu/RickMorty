package com.company.rickmorty.main.api

import com.company.rickmorty.main.models.character.CharacterData
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    fun getAllCharacters(): Call<CharacterData>
}