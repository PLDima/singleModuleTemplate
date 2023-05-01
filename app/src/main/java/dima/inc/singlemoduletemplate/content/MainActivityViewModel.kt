package dima.inc.singlemoduletemplate.content

import dagger.hilt.android.lifecycle.HiltViewModel
import dima.inc.singlemoduletemplate.common.CommonViewModel
import dima.inc.singlemoduletemplate.domain.repo.ArticlesRepository
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repo: ArticlesRepository
) : CommonViewModel() {

}