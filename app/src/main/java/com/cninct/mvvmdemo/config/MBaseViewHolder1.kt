package com.cninct.mvvmdemo.config

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class MBaseViewHolder1<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)