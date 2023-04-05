package com.example.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.databinding.ItemLayoutBinding

class NewsAdapter(val context: Context,val articles: List<Article>):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
   inner class ArticleViewHolder(binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
       var newsImage= binding.newsImage
       var newsTitle= binding.newsTitle
       var newsDescription= binding.newsDescription


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding=ItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ArticleViewHolder(binding)

    }

    override fun getItemCount(): Int {
      return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
       val article:Article= articles[position]
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.description

    }
}