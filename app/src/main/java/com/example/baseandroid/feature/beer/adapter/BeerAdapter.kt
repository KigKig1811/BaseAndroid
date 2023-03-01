package com.example.baseandroid.feature.beer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.baseandroid.databinding.BeerItemBinding
import com.example.common.R
import com.example.domain.entities.BeerResult


class BeerAdapter(private val listBeer: MutableList<BeerResult>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<BeerResult>() {
        override fun areItemsTheSame(oldItem: BeerResult, newItem: BeerResult): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BeerResult, newItem: BeerResult): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallBack)

    private var resultList: List<BeerResult>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    fun addAll(list: List<BeerResult>) {
        listBeer.clear()
        listBeer.addAll(list)
        resultList = listBeer
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BeerViewHolder(
            BeerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BeerViewHolder).bindView(resultList[position])
    }

    inner class BeerViewHolder(private val binding: BeerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: BeerResult) {
            binding.textName.text = item.name
            binding.textTagline.text = item.tagLine
            val size = binding.root.resources.getDimension(R.dimen.size_image_beer).toInt()
            binding.imgBeer.load(item.imageUrl) {
                size(size, size)
                crossfade(true)
                placeholder(R.drawable.image_place_holder)
                transformations(CircleCropTransformation())
                error(R.drawable.image_place_holder)
            }
        }
    }
}