package com.cninct.mvvmdemo.livedata.model

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountDownModel : ViewModel() {

    val countDownLiveData: MutableLiveData<String> = MutableLiveData()
    private var remainSecond = 100 //剩余时间

    init {
        val countDown = object : CountDownTimer(100 * 1000, 1000) {
            override fun onTick(p0: Long) {
                remainSecond--
                countDownLiveData.postValue("剩余${remainSecond}秒")
            }

            override fun onFinish() {
                countDownLiveData.postValue("倒计时结束")
            }
        }
        countDown.start()
    }
}