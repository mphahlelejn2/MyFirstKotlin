package com.kamo.myfirstkotlin.repo
import com.kamo.myfirstkotlin.news.ServerResponse
import io.reactivex.Maybe

 class NewsRepositoryImpl(private val restClient: RESTClient): NewsRepository {

  override fun getNewsList(api_key: String): Maybe<ServerResponse> {
   return restClient.getNewsList(api_key)
  }


}