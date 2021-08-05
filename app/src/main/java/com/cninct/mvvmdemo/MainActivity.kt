package com.cninct.mvvmdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cninct.mvvmdemo.databinding.ActivityMainBinding
import com.cninct.mvvmdemo.viewbinding.view.activity.FragmentActivity
import com.cninct.mvvmdemo.viewbinding.view.activity.UserListActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //两种写法是一样的
//        viewBinding = ActivityMainBinding.inflate(layoutInflater, null, false)
        viewBinding =
            ActivityMainBinding.bind(layoutInflater.inflate(R.layout.activity_main, null, false))
//        viewBinding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnUserList.setOnClickListener(this)
        viewBinding.btnFragmentTest.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnUserList -> {
                startActivity(Intent(this, UserListActivity::class.java))
            }
            R.id.btnFragmentTest -> {
                startActivity(Intent(this, FragmentActivity::class.java))
            }
        }
    }
}