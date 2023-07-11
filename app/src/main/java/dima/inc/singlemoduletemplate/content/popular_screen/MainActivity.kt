package dima.inc.singlemoduletemplate.content.popular_screen

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dima.inc.singlemoduletemplate.R
import dima.inc.singlemoduletemplate.common.model.Result
import dima.inc.singlemoduletemplate.content.popular_screen.adapters.SearchListAdapter
import dima.inc.singlemoduletemplate.data.models.Video
import dima.inc.singlemoduletemplate.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModelViewModel: MainActivityViewModelImpl by viewModels()
    private var savedQuery: String? = null
    private lateinit var searchListAdapter: SearchListAdapter

    private lateinit var binding: ActivityMainBinding

    private val progressDialog: AlertDialog by lazy {
        AlertDialog.Builder(this)
            .setView(R.layout.dialog_loading)
            .setCancelable(false)
            .create()
            .apply { window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContent()
        initCollectors()
    }

    private fun initCollectors() {
        lifecycleScope.launch {
            viewModelViewModel.requestStateHolder.getState().collect { state ->
                when (state) {
                    is Result.Loading -> {
                        progressDialog.show()
                    }

                    else -> {
                        progressDialog.dismiss()
                    }
                }
            }
        }
        lifecycleScope.launch {
            viewModelViewModel.videoList.collect { list ->
                showVideoList(list)
            }
        }
    }

    private fun initContent() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchListAdapter = SearchListAdapter(::onItemClick)
        binding.recyclerView.adapter = searchListAdapter
        viewModelViewModel.loadVideoList()
        binding.swipeRefreshLayout.setOnRefreshListener {
            savedQuery?.also(viewModelViewModel::searchVideoByName)
                ?: viewModelViewModel.loadVideoList()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchViewItem = menu?.findItem(R.id.search)
        val searchView = searchViewItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                savedQuery = query
                viewModelViewModel.searchVideoByName(searchView.query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun onItemClick(video: Video) {
        //Add realisation later
    }

    private fun showVideoList(videoList: List<Video>) {
        if (videoList.isNotEmpty()) {
            searchListAdapter.submitList(videoList)
            binding.swipeRefreshLayout.isRefreshing = false
        } else Toast.makeText(this, getString(R.string.nothing_to_show), Toast.LENGTH_SHORT).show()
    }
}