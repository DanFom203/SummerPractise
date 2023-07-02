package com.itis.myApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.itis.myApp.databinding.ItemFruitBinding

class FruitAdapter(
    private var list: List<Fruit>,
    private val glide: RequestManager,
    private val onItemClick: (Fruit) -> Unit,
) : RecyclerView.Adapter<FruitItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            FruitItem = FruitItem(
            ItemFruitBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        glide = glide,
        onItemClick = onItemClick,
        )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FruitItem, position: Int) {
        holder.onBind(list[position])
    }

    fun updateDataset(newList: List<Fruit>) {
        list = newList
        notifyDataSetChanged()
    }
}
