package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NewsAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.newsList.layoutManager=LinearLayoutManager(this@MainActivity)

        getNews()

    }

    private fun getNews() {
       val news=NewsApiInterface.newsApiInterface.newsInstance.getHeadLines("in",1)
        news.enqueue(object : retrofit2.Callback<responseDataClass?> {
            override fun onResponse(
                call: Call<responseDataClass?>,
                response: Response<responseDataClass?>
            ) {
                val news=response.body()
                if (news!=null){
                    Log.d("Abhishek",news.toString())
                    val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(this@MainActivity)
                    adapter= NewsAdapter(this@MainActivity,news.articles)

                    binding.newsList.adapter=adapter

                }
            }

            override fun onFailure(call: Call<responseDataClass?>, t: Throwable) {
               Log.d("ABHISHEK","ERROR")
            }
        })
    }
}