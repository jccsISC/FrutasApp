package com.jccsisc.frutasapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jccsisc.frutasapp.baseholder.BaseViewHolder
import com.jccsisc.frutasapp.databinding.CardFrutasBinding
import com.jccsisc.frutasapp.ui.model.Fruta
class MainAdapter(
    private val context: Context, private val frutasList: List<Fruta>,
    private val itemClickListener: OnClickFrutaListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBiding = CardFrutasBinding.inflate(LayoutInflater.from(context), parent, false)
        val holder = FruitViewHolde(itemBiding)
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is FruitViewHolde -> holder.bind(frutasList[position], position)
        }
    }

    override fun getItemCount(): Int = frutasList.size

    inner class FruitViewHolde(val binding: CardFrutasBinding) :
        BaseViewHolder<Fruta>(binding.root) {
        override fun bind(item: Fruta, position: Int) = with(binding) {

            Glide.with(context).load(item.image).centerCrop().into(binding.ivFruta)
            tvNameFruta.text = item.nombreFruta
            tvPrecio.text = "$ ${item.precioFruta.toString()}   "
            itemView.setOnClickListener { itemClickListener.onItemClick(item, position) }
        }
    }
}