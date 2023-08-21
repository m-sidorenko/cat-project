package com.msidorenko.cat_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo
import com.msidorenko.cat_project.databinding.ItemCatBinding

class AdapterSearchBreed() : RecyclerView.Adapter<AdapterSearchBreed.ViewHolderSearchBreed>() {
    var dataList = listOf<BreedInfo>()

    class ViewHolderSearchBreed(itemView: View) : RecyclerView.ViewHolder(itemView.rootView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSearchBreed {
        return ViewHolderSearchBreed(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_cat,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolderSearchBreed, position: Int) {
        val item = dataList[position]
        val binding = ItemCatBinding.bind(holder.itemView)

        Glide.with(holder.itemView).load(R.drawable.paw).into(binding.ivItemCat)
        binding.tvBreedNameItemCat.text = "Breed: " + item.name

        val weight = "weight: " + if (item.weight == null) {
            "unknown"
        } else {
            item.weight.metric + " kg"
        }
        binding.tvWeightItemCat.text = weight

        binding.tvOriginCountryItemCat.text = "origin country: " + item.origin
    }
}