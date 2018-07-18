package com.kamo.myfirstkotlin.news

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Jeffrey.Mphahlele on 2018/06/21.
 */


class News {
    @SerializedName("created_date")
    @Expose
    var created_date: String? = null
    @SerializedName("abstract")
    @Expose
    var abstract: String? = null
    @SerializedName("byline")
    @Expose
    var byline: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("multimedia")
    @Expose
    var multimedia: Array<Multimedia>? = null
    class Multimedia {
        @SerializedName("url")
        @Expose
        var url: String? = null
    }

}
