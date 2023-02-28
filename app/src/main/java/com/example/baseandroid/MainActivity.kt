package com.example.baseandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.data.entities.MemCache
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private val memCache: MemCache by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TEST",memCache.languageSelected)

    }
}