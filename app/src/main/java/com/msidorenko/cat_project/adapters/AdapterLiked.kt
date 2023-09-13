package com.msidorenko.cat_project.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.ItemBinding
import com.msidorenko.cat_project.db.LikedBreed
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo

class AdapterLiked : RecyclerView.Adapter<AdapterLiked.ViewHolderLikedBreed>() {

    private val differCallback = object : DiffUtil.ItemCallback<LikedBreed>() {
        override fun areItemsTheSame(oldItem: LikedBreed, newItem: LikedBreed): Boolean {
            return oldItem.breedInfo == newItem.breedInfo
        }

        override fun areContentsTheSame(oldItem: LikedBreed, newItem: LikedBreed): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    fun addItems(newItems: List<LikedBreed>) = differ.submitList(newItems)
    fun getItems(): MutableList<LikedBreed> = differ.currentList

    class ViewHolderLikedBreed(itemView: View) : RecyclerView.ViewHolder(itemView.rootView)

    private var onItemClickListener: (BreedInfo) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLikedBreed {
        return ViewHolderLikedBreed(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolderLikedBreed, position: Int) {
        val item = differ.currentList[position]
        val binding = ItemBinding.bind(holder.itemView)

        binding.tvBreedNameItemCat.text = item.breedInfo.name

        val weight = "weight: " + if (item.breedInfo.weight == null) {
            "unknown"
        } else {
            item.breedInfo.weight.metric + " kg"
        }
        binding.tvWeightItemCat.text = weight

        binding.tvOriginCountryItemCat.text = "origin country: " + item.breedInfo.origin

        holder.itemView.setOnClickListener {
            Log.i("MY TAG", "on click!")
            onItemClickListener(item.breedInfo)
        }

        val url = item.refImageLink
        if (url.isNullOrEmpty()) {
            binding.ivItemCat.load(R.drawable.fish_24) { transformations(CircleCropTransformation()) }
        } else {
            binding.ivItemCat.load(url) { transformations(CircleCropTransformation()) }
        }
    }

    fun setOnItemClickListener(listener: (breedNumber: BreedInfo) -> Unit) {
        onItemClickListener = listener
    }
}