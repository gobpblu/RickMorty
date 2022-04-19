package com.company.rickmorty.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.rickmorty.databinding.ActivityMainBinding
import com.company.rickmorty.main.api.RetrofitClient
import com.company.rickmorty.main.api.RickAndMortyApi
import com.company.rickmorty.main.models.character.CharacterData
import com.company.rickmorty.main.models.character.ResultResponse
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
        mainAdapter = MainAdapter(onClick = {sendDataToSecondActivity(it)})
        binding.mainRecyclerView.adapter = mainAdapter

        mainPresenter.attach(this)
        mainPresenter.getCharacterDataFromApi()
    }

    override fun showCharacters(data: CharacterData) {
        mainAdapter.setData(data.resultResponses)
    }

    override fun dataFailure(t: Throwable) {
        Timber.e(t.message)

    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.detach()
    }

    private fun sendDataToSecondActivity(resultResponse: ResultResponse) {
        val intent = Intent(this@MainActivity, CharacterActivity::class.java)
        intent.putExtra("result", resultResponse)
        startActivity(intent)
    }
}