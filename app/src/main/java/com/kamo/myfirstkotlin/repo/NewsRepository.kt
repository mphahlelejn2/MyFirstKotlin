package com.kamo.myfirstkotlin.repo
import com.kamo.myfirstkotlin.news.ServerResponse
import io.reactivex.Maybe

interface NewsRepository {
    fun getNewsList():Maybe<ServerResponse>
}