package io.relaworld.android.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.relaworld.android.databinding.FragmentFeedBinding

class GlobalFeedFragment: Fragment() {

    private var _binding: FragmentFeedBinding? = null
    lateinit var _viewModel: FeedViewModel
    private lateinit var feedAdapter: ArticleFeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedAdapter = ArticleFeedAdapter() // init adapter
        _binding = FragmentFeedBinding.inflate(inflater,container,false)

        _binding?.feedRecyclerView?.layoutManager = LinearLayoutManager(context)
        _binding?.feedRecyclerView?.adapter = feedAdapter
        _viewModel.fetchGlobalFeed()
        _viewModel.feed.observe({lifecycle}) {
            feedAdapter.submitList(it)
        }

        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}