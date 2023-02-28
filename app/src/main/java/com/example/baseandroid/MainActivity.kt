package com.example.baseandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.data.entities.MemCache
import org.koin.java.KoinJavaComponent.inject


class MainActivity : AppCompatActivity() {

    val memCache: MemCache by inject(MemCache::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TEST",memCache.languageSelected)

    }
}