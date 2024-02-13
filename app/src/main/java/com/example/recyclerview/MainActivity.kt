package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.newSingleThreadContext

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView:RecyclerView
    lateinit var newsArrayList:ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        var newsImageArray = intArrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
        )
        var newsHeadingArray = arrayOf(
            "Un, Foreian secretary James clevely olses issue or bbc tox searches with caM Jaishankar",
            "Cooking gas prices hiked by 260 for domestic, 2360.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )
        val newsContent = arrayOf(
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content)
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for(index in newsImageArray.indices){
            var news = News(newsHeadingArray[index],newsImageArray[index],newsContent[index])
            newsArrayList.add(news)
        }
        var myAdapter = MyAdapter(newsArrayList,this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onClickItem(position: Int) {
                // on clicking each item what action
                val intent = Intent(applicationContext,NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("image",newsArrayList[position].newsImage)
                intent.putExtra("content",newsArrayList[position].newsContent)
                startActivity(intent)

            }

        })


    }
}