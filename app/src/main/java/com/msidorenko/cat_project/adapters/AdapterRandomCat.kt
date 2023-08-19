package com.msidorenko.cat_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.msidorenko.cat_project.R
import com.msidorenko.cat_project.data.models.RandomCat

class AdapterRandomCat(): RecyclerView.Adapter<AdapterRandomCat.ViewHolderRandomCat>() {

    var dataList = listOf(
        RandomCat("1pd", "https://cdn2.thecatapi.com/images/1pd.jpg"),
        RandomCat("caq", "https://cdn2.thecatapi.com/images/caq.jpg"),
        RandomCat("79o", "https://cdn2.thecatapi.com/images/79o.jpg"),
        RandomCat("bd9", "https://cdn2.thecatapi.com/images/bd9.jpg"),
        RandomCat("beg", "https://cdn2.thecatapi.com/images/beg.jpg"),
        RandomCat("d1g", "https://cdn2.thecatapi.com/images/d1g.jpg"),
        RandomCat("d8t", "https://cdn2.thecatapi.com/images/d8t.jpg"),
        RandomCat("MTkzOTA4OQ", "https://cdn2.thecatapi.com/images/MTkzOTA4OQ.jpg"),
        RandomCat("MTk2NTM4NA", "https://cdn2.thecatapi.com/images/MTk2NTM4NA.jpg"),
        RandomCat("DEbrbE0_7", "https://cdn2.thecatapi.com/images/DEbrbE0_7.jpg"),
        RandomCat("1pd2", "https://cdn2.thecatapi.com/images/1pd.jpg"),
        RandomCat("caq2", "https://cdn2.thecatapi.com/images/caq.jpg"),
        RandomCat("79o2", "https://cdn2.thecatapi.com/images/79o.jpg"),
        RandomCat("bd92", "https://cdn2.thecatapi.com/images/bd9.jpg"),
        RandomCat("beg2", "https://cdn2.thecatapi.com/images/beg.jpg"),
        RandomCat("d1g2", "https://cdn2.thecatapi.com/images/d1g.jpg"),
        RandomCat("d8t2", "https://cdn2.thecatapi.com/images/d8t.jpg"),
        RandomCat("MTkzOTA4OQ2", "https://cdn2.thecatapi.com/images/MTkzOTA4OQ.jpg"),
        RandomCat("MTk2NTM4NA2", "https://cdn2.thecatapi.com/images/MTk2NTM4NA.jpg"),
        RandomCat("DEbrbE0_72", "https://cdn2.thecatapi.com/images/DEbrbE0_7.jpg")
    )

    class ViewHolderRandomCat(itemView: View) : RecyclerView.ViewHolder(itemView.rootView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRandomCat {
        return ViewHolderRandomCat(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_random_cat,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolderRandomCat, position: Int) {
        val item = dataList[position]

        holder.itemView.apply {
            val textView = findViewById<TextView>(R.id.tv_randomCatId)
            textView.text = item.id

            Glide.with(this.context).load(item.url).circleCrop().into(
                findViewById(R.id.iv_randomCat)
            )
        }
    }
}