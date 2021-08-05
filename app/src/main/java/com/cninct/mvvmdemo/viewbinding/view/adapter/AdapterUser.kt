package com.cninct.mvvmdemo.viewbinding.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cninct.mvvmdemo.R
import com.cninct.mvvmdemo.config.MBaseViewHolder
import com.cninct.mvvmdemo.databinding.ItemUserListBinding
import com.cninct.mvvmdemo.viewbinding.UserE

class AdapterUser : RecyclerView.Adapter<MBaseViewHolder>() {

    private var dataList: List<UserE> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MBaseViewHolder {
        val binding: ItemUserListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_user_list,
            parent,
            false
        )
        return MBaseViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MBaseViewHolder, position: Int) {
        val binding: ItemUserListBinding? = DataBindingUtil.getBinding(holder.itemView)
        binding?.apply {
            user = dataList[position]
            executePendingBindings()
        }
    }

    override fun getItemCount() = dataList.size

    fun setData(list: List<UserE>) {
        dataList = list
    }
}