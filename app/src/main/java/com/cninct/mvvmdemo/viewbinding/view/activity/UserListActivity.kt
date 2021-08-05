package com.cninct.mvvmdemo.viewbinding.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cninct.mvvmdemo.databinding.ActivityUserListBinding
import com.cninct.mvvmdemo.viewbinding.UserE
import com.cninct.mvvmdemo.viewbinding.view.adapter.AdapterUser

class UserListActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityUserListBinding
    private lateinit var adapterUser: AdapterUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        adapterUser = AdapterUser()
        viewBinding.listUser.adapter = adapterUser

        adapterUser.setData(listOf(UserE("张三", 18), UserE("李四", 19), UserE("王麻子", 20)))
        adapterUser.notifyDataSetChanged()
    }
}