package com.kamo.myfirstkotlin.news

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import com.kamo.myfirstkotlin.R
import dagger.android.support.AndroidSupportInjection
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.news_fragment.*
import javax.inject.Inject



class NewsFragment:Fragment(), INews.View {

    private lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var presenter: INews.Presenter
    private lateinit var loadingDialog: SpotsDialog

    private val recyclerView by lazy {
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(activity.application)
        recycler_view
    }

    companion object {
        fun newInstance()= NewsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater?.inflate(R.layout.news_fragment,container,false) as View
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        presenter.loadNews()
    }

    private fun init() {
        loadingDialog= SpotsDialog(activity,"Loading News .....")
    }

    override fun onPause() {
        super.onPause()
        presenter.clear()

    }

    override fun showNewsLoaderDialog() {
        loadingDialog.show()
    }


    override fun loadNews(newsList: List<News>) {
        recyclerView.adapter=NewsAdapter(newsList, context)
       // recyclerView.adapter=newsAdapter
    }

    override fun errorLoadingNews() {
        //Snackbar.make(get,"Error loading",Snackbar.LENGTH_SHORT).
    }

    override fun newsRepoEmpty() {

    }

    override fun closeLoader() {
        loadingDialog.hide()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
            AndroidSupportInjection.inject(this)
        }

}