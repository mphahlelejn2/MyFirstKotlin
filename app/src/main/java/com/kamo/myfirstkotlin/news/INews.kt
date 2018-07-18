package com.kamo.myfirstkotlin.news


/**
 * Created by Jeffrey.Mphahlele on 2018/06/21.
 */
interface INews {
    interface View {
        fun showNewsLoaderDialog()
        fun loadNews(t: List<News>)
        fun errorLoadingNews()
        fun newsRepoEmpty()
        fun closeLoader()
    }

    interface Presenter {
        fun clear()
        fun loadNews()
    }
}