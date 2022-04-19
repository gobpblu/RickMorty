package com.company.rickmorty.main.ui

import com.company.rickmorty.main.models.character.CharacterData


interface MainContract {
    fun showCharacters(data: CharacterData)
    fun dataFailure(t: Throwable)
}