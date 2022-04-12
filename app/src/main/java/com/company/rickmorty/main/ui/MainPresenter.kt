package com.company.rickmorty.main.ui

import com.company.rickmorty.main.api.RickAndMortyApi
import com.company.rickmorty.main.models.character.CharacterData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val api: RickAndMortyApi) {

    private var mainContract: MainContract? = null

    fun attach(mainContract: MainContract) {
        this.mainContract = mainContract
    }

    fun detach() {
        mainContract = null
    }

    fun getCharacterDataFromApi() {
        api.getAllCharacters()
            .enqueue(object : Callback<CharacterData> {
                override fun onResponse(
                    call: Call<CharacterData>,
                    response: Response<CharacterData>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val characters = response.body()

                    }
                }

                override fun onFailure(call: Call<CharacterData>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }

}