package com.company.rickmorty.main.ui

import com.company.rickmorty.main.models.character.CharacterData
import com.company.rickmorty.main.models.episode.EpisodeData
import com.company.rickmorty.main.models.location.LocationData


interface MainContract {
    fun showCharacterData(data: CharacterData)
    fun showLocationData(data: LocationData)
    fun showEpisodeData(data: EpisodeData)
    fun dataFailure(t: Throwable)
}