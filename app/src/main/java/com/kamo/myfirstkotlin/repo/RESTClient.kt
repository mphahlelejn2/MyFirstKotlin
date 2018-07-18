package com.kamo.myfirstkotlin.repo
import com.kamo.myfirstkotlin.news.ServerResponse
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Jeffrey.Mphahlele on 2018/06/22.
 */
interface RESTClient {

    @GET(UrlManager.POLITICS_END_POINT)
    fun getNewsList(@Query("api-key")api_key:String):Maybe<ServerResponse>

}