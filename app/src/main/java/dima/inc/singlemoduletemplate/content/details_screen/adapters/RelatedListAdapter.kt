package dima.inc.singlemoduletemplate.content.details_screen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dima.inc.singlemoduletemplate.R
import dima.inc.singlemoduletemplate.data.models.Video
import dima.inc.singlemoduletemplate.databinding.VideoListItemBinding

class RelatedListAdapter(private val onClickListener: (Video) -> Unit) :
    ListAdapter<Video, RelatedListAdapter.ViewHolder>(RelatedListCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val layoutInflater =
            parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val uiBinding = VideoListItemBinding.inflate(layoutInflater)
        return ViewHolder(uiBinding, onClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.currentVideo = getItem(position)
        holder.bind()
    }

    class ViewHolder(private val uiBinding: VideoListItemBinding, handler: (Video) -> Unit) :
        RecyclerView.ViewHolder(uiBinding.root) {

        private val listener: View.OnClickListener = View.OnClickListener { handler(currentVideo) }
        lateinit var currentVideo: Video

        fun bind() {
            with(uiBinding) {
                Glide.with(root.context)
                    .load(currentVideo.iconUri)
                    .into(videoIconImageView)
                videoNameTextView.text = currentVideo.name
                videoViewCountTextView.text =
                    root.context.getString(R.string.viewAmountTemplate, currentVideo.views.toString())
                root.setOnClickListener(listener)
            }
        }
    }
}
