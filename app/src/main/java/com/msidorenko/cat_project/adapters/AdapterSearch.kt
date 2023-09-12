package com.msidorenko.cat_project.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.databinding.ItemSearchBinding
import com.msidorenko.cat_project.retrofit.RetrofitClient
import com.msidorenko.cat_project.retrofit.api.models.BreedInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdapterSearch : RecyclerView.Adapter<AdapterSearch.ViewHolderSearchBreed>() {

    private val differCallback = object : DiffUtil.ItemCallback<BreedInfo>() {
        override fun areItemsTheSame(oldItem: BreedInfo, newItem: BreedInfo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BreedInfo, newItem: BreedInfo): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    fun addItems(newItems: List<BreedInfo>) = differ.submitList(newItems)
    fun getItems(): MutableList<BreedInfo> = differ.currentList

    class ViewHolderSearchBreed(itemView: View) : RecyclerView.ViewHolder(itemView.rootView)

    private var onItemClickListener: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSearchBreed {
        return ViewHolderSearchBreed(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolderSearchBreed, position: Int) {
        val item = differ.currentList[position]
        val binding = ItemSearchBinding.bind(holder.itemView)

        binding.tvBreedNameItemCat.text = item.name

        val weight = "weight: " + if (item.weight == null) {
            "unknown"
        } else {
            item.weight.metric + " kg"
        }
        binding.tvWeightItemCat.text = weight

        binding.tvOriginCountryItemCat.text = "origin country: " + item.origin


        binding.btnHeart.setOnClickListener {
            Log.i("MY TAG", "HEART BUTTON")

        }

        holder.itemView.setOnClickListener {
            Log.i("MY TAG", "on click!")
            onItemClickListener(position)
        }

        val retrofit = RetrofitClient.instance

        CoroutineScope(Dispatchers.Main).launch {
            val referenceImageId = item.referenceImageId
            if (referenceImageId != null) {
                val result = retrofit.getImageById(referenceImageId)
                if (result.isSuccessful) {
                    val url = result.body()?.url
                    if (url != null) {
                        Glide.with(holder.itemView.context).load(url).circleCrop().into(binding.ivItemCat)
                    }
                } else {
                    Glide.with(holder.itemView).load(R.drawable.fish_24).circleCrop().into(binding.ivItemCat)
                }
            } else {
                Glide.with(holder.itemView).load(R.drawable.fish_24).circleCrop().into(binding.ivItemCat)
            }
        }
    }

    fun setOnItemClickListener(listener: (breedNumber: Int) -> Unit) {
        onItemClickListener = listener
    }
}