package com.cninct.mvvmdemo.viewbinding.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cninct.mvvmdemo.databinding.FragmentTestBinding


/**
 * create an instance of this fragment.
 */
class TestFragment : Fragment() {

    private var binding: FragmentTestBinding? = null

    companion object {
        @JvmStatic
        fun newInstance() = TestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        binding?.apply {
            tvContent.text = "哈哈哈哈哈哈"
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}