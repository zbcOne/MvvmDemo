package com.cninct.mvvmdemo.viewbinding.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cninct.mvvmdemo.R
import com.cninct.mvvmdemo.databinding.FragmentTest1Binding
import com.cninct.mvvmdemo.viewbinding.property.viewBindingV1

class Test1Fragment : Fragment(R.layout.fragment_test1) {

    private val binding: FragmentTest1Binding by viewBindingV1()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvContent.text = "鹅鹅鹅鹅鹅鹅"
    }
}