package com.kamo.myfirstkotlin.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.kamo.myfirstkotlin.R
import com.kamo.myfirstkotlin.Util.PicassoTrustAll
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_list_item.view.*
import java.net.URL


class NewsAdapter(private val newsList:List<News>, private val context:Context): RecyclerView.Adapter<NewsAdapter.UserViewHolder>() {

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        if(newsList[position].multimedia!!.isNotEmpty()){

            PicassoTrustAll.getInstance(context).load(newsList[position].multimedia!![0].url.toString())
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher)
                    .resize(80, 80)
                    .into(holder?.image);
        System.out.println("llllllllllllllllllllllllllllllllllllll........"+ newsList[position].multimedia!![0].url)}
            //Glide.with(context).load(newsList[position].multimedia!![0].url).diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().into(holder?.image);
            //Glide.with(context).load(URL(newsList[position].multimedia!![0].url.toString())).into(holder?.image);
           // Glide.with(context)load(newsList[position].multimedia!![0].url.toString()).into(holder?.image);
            //Picasso.with(context).load(newsList[position].multimedia!![0].url.toString()).into(holder?.image);

       // Picasso.with(context).load(newsList[position].multimedia!![0].url).into(holder?.image);
        holder?.date?.text= newsList[position].created_date
        holder?.title?.text= newsList[position].title
        holder?.author?.text= newsList[position].byline
    }

     override fun getItemCount()=newsList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.news_list_item, parent, false))
    }

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val author=view.news_author
        val image=view.news_image
        //val author=view.findViewById<TextView>(R.id.news_author)
        val title= view.news_title
        var date=view.news_date
    }
}