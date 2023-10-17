package com.sendabouquet.swapi_express.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sendabouquet.swapi_express.data.Star
import com.sendabouquet.swapi_express.databinding.ItemStarCardBinding

class StarAdapter(private val listChar: ArrayList<Star>) :
    RecyclerView.Adapter<StarAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemStarCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemStarCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val b = holder.binding
        val (title, secondary, support, photo) = listChar[position]
        b.imageView.load(photo)
        b.tvTitle.text = title
        b.tvSecondary.text = secondary
    }

    override fun getItemCount(): Int = listChar.size

}