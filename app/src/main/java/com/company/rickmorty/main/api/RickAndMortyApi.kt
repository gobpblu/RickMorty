package com.company.rickmorty.main.api

import com.company.rickmorty.main.models.character.CharacterData
import com.company.rickmorty.main.models.episode.EpisodeData
import com.company.rickmorty.main.models.location.LocationData
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    fun getAllCharacters(): Call<CharacterData>

    @GET("location")
    fun getAllLocations(): Call<LocationData>

    @GET("episode")
    fun getAllEpisodes(): Call<EpisodeData>
}