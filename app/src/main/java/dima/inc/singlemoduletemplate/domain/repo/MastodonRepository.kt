package dima.inc.singlemoduletemplate.domain.repo

import dima.inc.singlemoduletemplate.domain.models.MastodonInfo
import dima.inc.singlemoduletemplate.common.model.Result

interface MastodonRepository{
    suspend fun getInstances(): Result<List<MastodonInfo>>
}