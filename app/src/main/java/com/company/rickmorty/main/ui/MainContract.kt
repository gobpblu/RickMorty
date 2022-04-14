package com.company.rickmorty.main.ui

import com.company.rickmorty.main.models.character.CharacterData
import com.company.rickmorty.main.models.character.Result
import com.company.rickmorty.main.models.episode.EpisodeData
import com.company.rickmorty.main.models.location.LocationData


interface MainContract {
    fun showCharacters(data: CharacterData)
    fun dataFailure(t: Throwable)
}