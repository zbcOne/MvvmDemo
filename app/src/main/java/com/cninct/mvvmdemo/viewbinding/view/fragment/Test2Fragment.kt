package com.cninct.mvvmdemo.viewbinding.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.cninct.mvvmdemo.R
import com.cninct.mvvmdemo.databinding.FragmentTest2Binding

class Test2Fragment : Fragment(R.layout.fragment_test2) {

    private val binding: FragmentTest2Binding by viewBindingV2(FragmentTest2Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvContent.text = "嘻嘻嘻嘻嘻嘻嘻"
    }
}