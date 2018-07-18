package com.kamo.myfirstkotlin.rxJava

import io.reactivex.Scheduler

 interface BaseSchedulerProvider {
 fun io(): Scheduler
 fun ui(): Scheduler
}