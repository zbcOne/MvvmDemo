package com.cninct.mvvmdemo.viewbinding.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cninct.mvvmdemo.R
import com.cninct.mvvmdemo.config.MBaseViewHolder1
import com.cninct.mvvmdemo.databinding.ItemUserList1Binding
import com.cninct.mvvmdemo.viewbinding.UserE

class AdapterUser1 : RecyclerView.Adapter<MBaseViewHolder1<ItemUserList1Binding>>() {

    private var dataList: List<UserE> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MBaseViewHolder1<ItemUserList1Binding> {
        return MBaseViewHolder1(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_user_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MBaseViewHolder1<ItemUserList1Binding>, position: Int) {
        holder.binding.apply {
            user = dataList[position]
            executePendingBindings()
        }
    }

    override fun getItemCount() = dataList.size

    fun setData(list: List<UserE>) {
        dataList = list
    }
}