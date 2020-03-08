package com.example.wikipedia.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wikipedia.R
import com.example.wikipedia.holders.ListItemHolder
import com.example.wikipedia.models.WikiPage

class ArticleListItemRecyclerAdapter(): RecyclerView.Adapter<ListItemHolder>() {

    val currentResults : ArrayList<WikiPage> = ArrayList<WikiPage>()

    override fun getItemCount(): Int {

        return currentResults.size
    }

    override fun onBindViewHolder(p0: ListItemHolder, p1: Int) {
        //this is where we will update our view
        var page = currentResults[p1]
        p0.updateWithPage(page)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListItemHolder {
        var cardItem= LayoutInflater.from(p0.context).inflate(R.layout.article_list_item,p0, false)
        return ListItemHolder(cardItem)
    }
}