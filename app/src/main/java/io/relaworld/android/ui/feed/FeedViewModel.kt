package io.relaworld.android.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.relaworld.android.data.ArticlesRepo
import io.relaworld.api.models.entities.Article
import kotlinx.coroutines.launch

class FeedViewModel: ViewModel() {

    private val _feed = MutableLiveData<List<Article>>()

    val feed : LiveData<List<Article>> = _feed

    // launch a coroutines scope / viewModel Scope
    fun fetchGlobalFeed() = viewModelScope.launch {
           ArticlesRepo.getGlobalFeed().body()?.let {
              _feed.postValue(it.articles)
              Log.d("FEED","feed fetched ${it.articlesCount}")
          }

        }


}