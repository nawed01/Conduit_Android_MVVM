package io.relaworld.android.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.relaworld.android.R
import io.relaworld.android.databinding.ListItemArticleBinding
import io.relaworld.api.models.entities.Article

class ArticleFeedAdapter : androidx.recyclerview.widget.ListAdapter<Article,ArticleFeedAdapter.ArticleViewHolder>(
    object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
          return oldItem.toString() == newItem.toString()
        }

    }
) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val view = parent.context.getSystemService(LayoutInflater::class.java).inflate(R.layout.list_item_article,
        parent,
        false
        )
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        ListItemArticleBinding.bind(holder.itemView).apply {
            val article = getItem(position)

            textViewName.text = article.author.username
            textViewTitle.text = article.title
            textViewBody.text = article.body
            textViewDate.text = article.createdAt
        }
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}