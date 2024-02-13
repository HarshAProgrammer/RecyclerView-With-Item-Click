package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)


        val heading = intent.getStringExtra("heading")
        val content = intent.getStringExtra("content")
        val image = intent.getIntExtra("image",R.drawable.img5)

        val titleTv = findViewById<TextView>(R.id.newsHeading)
        val imageIv = findViewById<ImageView>(R.id.newsImage)
        val contentTv = findViewById<TextView>(R.id.newsContent)

        titleTv.text = heading
        imageIv.setImageResource(image)
        contentTv.text = content




    }
}