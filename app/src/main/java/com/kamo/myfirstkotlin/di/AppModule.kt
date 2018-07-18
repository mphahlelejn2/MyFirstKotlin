package com.kamo.myfirstkotlin.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kamo.myfirstkotlin.repo.NewsRepository
import com.kamo.myfirstkotlin.repo.NewsRepositoryImpl
import com.kamo.myfirstkotlin.repo.RESTClient
import com.kamo.myfirstkotlin.repo.UrlManager
import com.kamo.myfirstkotlin.rxJava.BaseSchedulerProvider
import com.kamo.myfirstkotlin.rxJava.SchedulerProviderImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
internal class AppModule {


    @Provides
    @Singleton
    internal fun getGson(): Gson {
        return GsonBuilder().create()
    }


    @Provides
    @Singleton
    fun getRestApi(gson:Gson): RESTClient
    {
        /*return Retrofit.Builder()
                .baseUrl(UrlManager.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build().create(RESTClient::class.java)*/
      /*  return Retrofit.Builder()
                .baseUrl(UrlManager.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create<RESTClient>(RESTClient::class.java)*/
        /*return Retrofit.Builder()
                .baseUrl(UrlManager.BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create<RESTClient>(RESTClient::class.java)*/

        return Retrofit.Builder()
                .baseUrl(UrlManager.BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create<RESTClient>(RESTClient::class.java)
    }

    @Provides
    @Singleton
    fun getBaseSchedulerProvider(): BaseSchedulerProvider {
        return SchedulerProviderImpl()
    }


    @Provides
    @Singleton
    fun getRepository(restClient: RESTClient): NewsRepository
    {
        return NewsRepositoryImpl(restClient)
    }

}