package dima.inc.singlemoduletemplate.content.details_screen

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import dagger.hilt.android.AndroidEntryPoint
import dima.inc.singlemoduletemplate.BuildConfig
import dima.inc.singlemoduletemplate.R
import dima.inc.singlemoduletemplate.common.utils.StatsConverter.convertStatsToString
import dima.inc.singlemoduletemplate.common.views.ProgressDialog
import dima.inc.singlemoduletemplate.content.details_screen.adapters.RelatedListAdapter
import dima.inc.singlemoduletemplate.data.models.Video
import dima.inc.singlemoduletemplate.databinding.VideoDetailsLayoutBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VideoDetailsActivity : AppCompatActivity(), YouTubePlayer.OnInitializedListener {

    private val videoDetailsViewModel: VideoDetailsViewModel by viewModels<VideoDetailsViewModelImpl>()

    private lateinit var uiBinding: VideoDetailsLayoutBinding
    private lateinit var relatedListAdapter: RelatedListAdapter
    private lateinit var youTubePlayer: YouTubePlayer
    private val youTubePlayerFragment = YouTubePlayerSupportFragment()
    private var currentVideo: Video? = null

    private val progressDialog = ProgressDialog(baseContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContent()
        initCollectors()
    }

    private fun initCollectors() {
        lifecycleScope.launch {
            videoDetailsViewModel.relatedVideoList.collect { list ->
                showVideoList(list)
            }
        }
    }

    private fun showVideoList(list: List<Video>) {
        relatedListAdapter.submitList(list)
        uiBinding.swipeRefreshLayout.isRefreshing = false
    }

    private fun initContent() {
        uiBinding = VideoDetailsLayoutBinding.inflate(layoutInflater)
        setContentView(uiBinding.root)
        /**
         * Deprecated code that doesn't work at androidx. unfortunately
         * the project was frozen cause this problems
         */
        youTubePlayerFragment.initialize(BuildConfig.API_KEY, this)
        supportFragmentManager.commit {
            replace(uiBinding.youTubePlayerFrameLayout.id, youTubePlayerFragment)
        }
        relatedListAdapter = RelatedListAdapter(::onVideoClicked)
        uiBinding.recyclerView.adapter = relatedListAdapter
        uiBinding.swipeRefreshLayout.setOnRefreshListener {
            videoDetailsViewModel.loadRelatedVideoList(currentVideo)
        }
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider,
        player: YouTubePlayer,
        wasRestored: Boolean,
    ) {
        youTubePlayer = player
        currentVideo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(VIDEO_INTENT_KEY, Video::class.java)
        } else {
            intent.getParcelableExtra(VIDEO_INTENT_KEY)
        }
        playVideo(currentVideo)
    }

    private fun playVideo(video: Video?) {
        youTubePlayer.cueVideo(video?.videoId)
        youTubePlayer.play()
    }

    private fun onVideoClicked(video: Video?) {
        lifecycleScope.launch {
            try {
                progressDialog.show()
                showVideoData(video)
                playVideo(video)
            } finally {
                progressDialog.hide()
            }
        }
    }

    private fun showVideoData(video: Video?) {
        uiBinding.detailsScrollView.smoothScrollTo(0, 0)
        uiBinding.videoNameTextView.text = video?.name
        uiBinding.videoDescriptionTextView.text = video?.description
        uiBinding.videoViewsTextView.text = convertStatsToString(video?.views ?: 0, this)
        uiBinding.likesTextView.text = convertStatsToString(video?.likes ?: 0, this)
        uiBinding.dislikesTextView.text = convertStatsToString(video?.dislikes ?: 0, this)
        videoDetailsViewModel.loadRelatedVideoList(video)
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        error: YouTubeInitializationResult?,
    ) {
        Log.e("Logs", "video player initialization error $error")
        Toast.makeText(this, getString(R.string.playerError), Toast.LENGTH_SHORT).show()
    }


    private companion object {
        private const val VIDEO_INTENT_KEY = "video"
    }
}