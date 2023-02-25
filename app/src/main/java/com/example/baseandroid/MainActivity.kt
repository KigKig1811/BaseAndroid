package com.example.baseandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.common.base.BaseActivity
import com.example.data.entities.MemCache


class MainActivity : AppCompatActivity() {

    val memCache: MemCache by inject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}