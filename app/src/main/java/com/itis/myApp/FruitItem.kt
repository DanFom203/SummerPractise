package com.itis.myApp

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.myApp.databinding.ItemFruitBinding

class FruitItem(
    private val binding: ItemFruitBinding,
    private val glide: RequestManager,
    private val onItemClick: (Fruit) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(fruit: Fruit) {
        binding.run {
            tvTitle.text = fruit.name
            tvDesc.text = fruit.description

            glide
                .load(fruit.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .apply(options)
                .into(ivImage)

            root.setOnClickListener {
                onItemClick(fruit)
            }
        }
    }
}