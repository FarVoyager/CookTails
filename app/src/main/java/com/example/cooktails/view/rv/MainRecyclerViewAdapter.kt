package com.example.cooktails.view.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cooktails.databinding.RecyclerViewItemBinding
import com.example.cooktails.view.glide.IImageLoader

class MainRecyclerViewAdapter(val presenter: IListPresenter.IMainListPresenter, val imageLoader: IImageLoader<ImageView>):
    RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolderMain>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMain {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewHolderMain(binding)
        viewHolder.itemView.setOnClickListener { presenter.itemClickListener?.invoke(viewHolder) }
        return viewHolder
    }


    override fun onBindViewHolder(holder: ViewHolderMain, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }

    inner class ViewHolderMain(private val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root), MainItemView {

        override var pos = -1

        override fun setName(text: String) {
            binding.textViewName.text = text
        }

        override fun setImage(url: String) {
            imageLoader.loadInto(url, binding.recyclerItemImageView)
        }

        override fun setCategory(text: String) {
            binding.textViewCategory.text = text
        }

        override fun setAlcoholic(text: String) {
            binding.textViewAlcoholic.text = text
        }

        override fun setRecipe(text: String) {
            binding.textViewRecipe.text = text
        }
    }

}