package com.kamo.myfirstkotlin.news

import com.google.gson.annotations.SerializedName



/**
 * Created by Jeffrey.Mphahlele on 2018/06/29.
 */
class ServerResponse(
        @SerializedName("results")
        val newsList:List<News>)
