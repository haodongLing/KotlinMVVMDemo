package com.haodong.lib.common.core

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import qiu.niorgai.StatusBarCompat

/**
 * Author: tangyuan
 * Time : 2021/8/14
 * Description:
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        beforeSetContentView(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        setStatusBar()
        initView()
        initData()
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()
    open fun beforeSetContentView(savedInstanceState: Bundle?){


    }
    open fun setStatusBar(){
        //透明状态栏
        StatusBarCompat.translucentStatusBar(this@BaseActivity);
    }


}