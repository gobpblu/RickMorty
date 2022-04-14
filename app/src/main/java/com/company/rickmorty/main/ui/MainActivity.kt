package com.company.rickmorty.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.rickmorty.R
import com.company.rickmorty.databinding.ActivityMainBinding
import com.company.rickmorty.main.api.RetrofitClient
import com.company.rickmorty.main.api.RickAndMortyApi
import com.company.rickmorty.main.models.character.CharacterData
import com.company.rickmorty.main.models.character.Result
import com.company.rickmorty.main.models.episode.EpisodeData
import com.company.rickmorty.main.models.location.LocationData
import timber.log.Timber

class MainActivity : AppCompatActivity(), MainContract {

    private val api: RickAndMortyApi = RetrofitClient.getRetrofit().create(RickAndMortyApi::class.java)

    private val mainPresenter = MainPresenter(api)

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var characterData: CharacterData

    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainAdapter = MainAdapter()
        binding.mainRecyclerView.adapter = mainAdapter

        mainPresenter.attach(this)
        mainPresenter.getCharacterDataFromApi()

    }

    override fun showCharacters(data: CharacterData) {
        mainAdapter.setData(data.results)
    }

    override fun dataFailure(t: Throwable) {
        Timber.e(t.message)

    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.detach()
    }
}