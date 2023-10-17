package com.sendabouquet.swapi_express.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sendabouquet.swapi_express.DetailActivity
import com.sendabouquet.swapi_express.R
import com.sendabouquet.swapi_express.data.Star
import com.sendabouquet.swapi_express.databinding.ItemStarCardBinding

class StarAdapter(private val listChar: ArrayList<Star>) :
    RecyclerView.Adapter<StarAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemStarCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemStarCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val b = holder.binding
        val star = listChar[position]
        b.imageView.load(star.photo) {
            Log.d("COIL", star.photo)
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_connection_error)
        }
        b.tvTitle.text = star.title
        b.tvSecondary.text = star.secondary

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.detail, listChar[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listChar.size

}