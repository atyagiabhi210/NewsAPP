package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

// we declare methods to call endpoints
//https://newsapi.org/v2/everything?&apiKey=876e204c9faf44e8a2b2d6b7254c1ccf
//https://newsapi.org/v2/top-headlines?country=in&apiKey=876e204c9faf44e8a2b2d6b7254c1ccf
const val BaseURL="https://newsapi.org/"
const val APIKey="876e204c9faf44e8a2b2d6b7254c1ccf"
interface NewsApiInterface {
    @GET("v2/top-headlines?api-key=$APIKey")
    fun getHeadLines(@Query("country") country:String, @Query("page") page:Int):Call<responseDataClass>

    object newsApiInterface{
        val newsInstance:NewsApiInterface
        init {
            val retrofit:Retrofit= Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            newsInstance=retrofit.create(NewsApiInterface::class.java)
        }
    }
}
