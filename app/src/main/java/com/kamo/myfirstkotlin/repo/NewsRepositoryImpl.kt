package com.kamo.myfirstkotlin.repo
import com.kamo.myfirstkotlin.news.ServerResponse
import io.reactivex.Maybe

 class NewsRepositoryImpl(private val restClient: RESTClient): NewsRepository {
 override fun getNewsList(): Maybe<ServerResponse> {
  return restClient.getNewsList()
 }
}