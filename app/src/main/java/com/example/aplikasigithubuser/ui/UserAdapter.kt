package com.example.aplikasigithubuser.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.aplikasigithubuser.data.response.ItemsItem
import com.example.aplikasigithubuser.databinding.ItemUserBinding


class UserAdapter : ListAdapter<ItemsItem, UserAdapter.MyViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class MyViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: ItemsItem){

            binding.root.setOnClickListener {

            }

            Glide.with(itemView)
                .load(user.avatarUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(binding.imgItemPhoto)
            binding.tvItemName.text = user.login
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val userItem = getItem(position)
        holder.bind(userItem)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ItemsItem)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemsItem>() {
            override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
                return oldItem == newItem
            }
        }
    }


}