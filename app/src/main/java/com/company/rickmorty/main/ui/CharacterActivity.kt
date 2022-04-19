package com.company.rickmorty.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.company.rickmorty.R
import com.company.rickmorty.databinding.ActivityCharacterBinding
import com.company.rickmorty.main.models.character.ResultResponse


class CharacterActivity : AppCompatActivity() {

    private val binding: ActivityCharacterBinding by lazy {
        ActivityCharacterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResultResponse>("result")
//        val imageView: ImageView = findViewById(R.id.characterImageView)

        with(binding) {
            Glide.with(this@CharacterActivity).load(data?.image).into(characterImageView)
            textViewName.text = "Name: ${data?.name}"
            textViewGender.text = "Gender: ${data?.gender}"
            textViewStatus.text = "Status: ${data?.status}"
            textViewSpecies.text = "Species: ${data?.species}"
        }


    }
}