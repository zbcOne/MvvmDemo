package com.cninct.mvvmdemo.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cninct.mvvmdemo.R
import com.cninct.mvvmdemo.databinding.ActivityLiveDataTestBinding

class LiveDataTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveDataTestBinding
    private var liveData: MutableLiveData<String> = MutableLiveData("哈哈哈哈")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLiveDataTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dataValue = liveData.value
        liveData.observe(this, {
            binding.dataValue = it
            Log.e("zz", "单独使用LiveData ==> $it")
        })
    }

    override fun onStop() {
        super.onStop()
        liveData.postValue("LiveData练习")
    }
}