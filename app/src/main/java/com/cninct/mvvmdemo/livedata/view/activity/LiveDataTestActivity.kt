package com.cninct.mvvmdemo.livedata.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.cninct.mvvmdemo.databinding.ActivityLiveDataTestBinding
import com.cninct.mvvmdemo.livedata.model.CountDownModel

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

        val countDownModel: CountDownModel = ViewModelProvider(this).get(CountDownModel::class.java)
        countDownModel.countDownLiveData.observe(this, {
            binding.tvCountDown.text = it
        })
    }

    override fun onStop() {
        super.onStop()
        liveData.postValue("LiveData练习")
    }
}