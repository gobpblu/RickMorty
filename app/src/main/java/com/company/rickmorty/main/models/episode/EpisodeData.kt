package com.company.rickmorty.main.models.episode

import com.google.gson.annotations.SerializedName

data class EpisodeData(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)
