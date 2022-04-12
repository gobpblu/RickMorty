package com.company.rickmorty.main.models.character

import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)
