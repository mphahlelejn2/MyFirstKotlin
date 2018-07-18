package com.kamo.myfirstkotlin.di
import com.kamo.myfirstkotlin.news.NewsFragment
import com.kamo.myfirstkotlin.news.NewsModule
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector


@Module(includes = arrayOf(AndroidInjectionModule::class))
abstract class Builder {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(NewsModule::class))
    internal abstract fun bindNewsFragment(): NewsFragment

}