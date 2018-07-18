package com.kamo.myfirstkotlin.repo

class UrlManager {

    companion object {
        val BASE_URL="https://api.nytimes.com/"
        const val POLITICS_END_POINT = "svc/topstories/v2/politics.json?api-key=8a715210f6dc4ca7aa73094f4a8d5e64"
       // val BASE_URL="https://api.nytimes.com/svc/topstories/v2/home.json?api-key=8a715210f6dc4ca7aa73094f4a8d5e64"
        val KEY="8a715210f6dc4ca7aa73094f4a8d5e64"
        //val BASE_URL="https://api.nytimes.com/svc/topstories/v2/politics.json?api-key=8a715210f6dc4ca7aa73094f4a8d5e64/"
    }
}