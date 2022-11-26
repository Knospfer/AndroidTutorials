package com.mberrueta.a17_swipable_views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

//posso prendere le immagini per id perchè le ho nelle cartelle globali
class ViewPagerAdapter(val images: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerVIewHolder>() {
    inner class ViewPagerVIewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerVIewHolder {
        //quando inflato
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager, parent, false)
        return ViewPagerVIewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerVIewHolder, position: Int) {
        val currentImage = images[position]
        holder.itemView.apply {
            holder.ivImage.setImageResource(currentImage)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
}