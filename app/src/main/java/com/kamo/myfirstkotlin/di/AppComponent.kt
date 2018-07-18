package com.kamo.myfirstkotlin.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules= arrayOf(AndroidSupportInjectionModule::class, AppModule::class, Builder::class))
interface AppComponent: AndroidInjector<KotlinDemoApp> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application:Application): Builder
         fun build(): AppComponent
    }

    override fun inject(instance: KotlinDemoApp?)

}

