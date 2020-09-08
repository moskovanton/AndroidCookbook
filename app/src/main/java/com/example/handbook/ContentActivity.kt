package com.example.handbook

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*

class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        tvTitle.text = intent.getStringExtra("TITLE")
        tvContent.text = intent.getStringExtra("CONTENT")
        im.setImageResource(intent.getIntExtra("IMG", R.drawable.ic_launcher_background))
    }
}