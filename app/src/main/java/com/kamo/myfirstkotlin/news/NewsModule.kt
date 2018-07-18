package com.kamo.myfirstkotlin.news
import com.kamo.myfirstkotlin.repo.NewsRepository
import com.kamo.myfirstkotlin.rxJava.BaseSchedulerProvider
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
 abstract class NewsModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
         fun getNewsPresenter(view: INews.View, newsRepository: NewsRepository, schedulerProvider: BaseSchedulerProvider): INews.Presenter
        {
            return NewsPresenterImpl(view,newsRepository,schedulerProvider)
        }
    }


    @Binds
     abstract fun  getView(newsFragment: NewsFragment): INews.View

}