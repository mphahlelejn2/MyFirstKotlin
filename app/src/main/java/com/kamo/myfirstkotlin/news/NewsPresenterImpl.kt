package com.kamo.myfirstkotlin.news

import com.kamo.myfirstkotlin.repo.NewsRepository
import com.kamo.myfirstkotlin.rxJava.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableMaybeObserver

class NewsPresenterImpl(val view: INews.View, private val newsRepository: NewsRepository, private val scheduler: BaseSchedulerProvider): INews.Presenter {

    private val composite=CompositeDisposable()

    override fun loadNews() {
        view.showNewsLoaderDialog()
        composite.add(newsRepository.getNewsList()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribeWith(object:DisposableMaybeObserver<ServerResponse>(){
                    override fun onComplete() {
                         view.newsRepoEmpty()
                         view.closeLoader()
                    }

                    override fun onError(e: Throwable) {
                        view.errorLoadingNews()
                        view.closeLoader()

                    }
                    override fun onSuccess(t: ServerResponse) {
                       // System.out.print("............................................................"+t.newsList.size)
                        view.loadNews(t.newsList)
                        view.closeLoader()
                    }
                }
                )
              )
    }

    override fun clear() {
        composite.clear()
    }
}