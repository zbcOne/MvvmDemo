package com.cninct.mvvmdemo.viewbinding.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cninct.mvvmdemo.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}