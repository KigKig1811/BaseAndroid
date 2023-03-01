package com.example.baseandroid

import com.example.common.base.BaseActivity
import com.example.domain.entities.MemCache
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity(R.layout.activity_main) {

    private val memCache: MemCache by inject()

}