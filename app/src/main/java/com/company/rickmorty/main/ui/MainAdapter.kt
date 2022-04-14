package com.company.rickmorty.main.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.company.rickmorty.R
import com.company.rickmorty.main.models.character.Result

class MainAdapter() : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val characters = mutableListOf<Result>()


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.image_view1)
        private val textView1: TextView = itemView.findViewById(R.id.text_view1)
        private val textView2: TextView = itemView.findViewById(R.id.text_view2)


        fun bind(result: Result) {
            Glide.with(itemView.context).load(result.image).into(imageView)
            textView1.text = result.name
            textView2.text = result.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val listItem = characters[position]
        holder.bind(listItem)
    }

    override fun getItemCount() = characters.size

    fun setData(list: List<Result>) {
        characters.clear()
        characters.addAll(list)

        notifyDataSetChanged()
    }


}