package dima.inc.singlemoduletemplate.content.details_screen.adapters

import androidx.recyclerview.widget.DiffUtil
import dima.inc.singlemoduletemplate.data.models.Video

object RelatedListCallback : DiffUtil.ItemCallback<Video>() {
    override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.videoId == newItem.videoId
    }

    override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.name == newItem.name && oldItem.views == newItem.views && oldItem.iconUri == newItem.iconUri
    }
}