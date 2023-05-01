package dima.inc.singlemoduletemplate.content

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dima.inc.singlemoduletemplate.R
import dima.inc.singlemoduletemplate.common.CommonActivity
import dima.inc.singlemoduletemplate.domain.repo.ArticlesRepository
import dima.inc.stardartarchitecture.ui.main.common.utils.RequestResult
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : CommonActivity(R.layout.activity_main) {

    private val viewModelViewModel: MainActivityViewModel by viewModels()
}