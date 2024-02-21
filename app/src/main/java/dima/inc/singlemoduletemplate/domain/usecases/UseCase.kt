package dima.inc.singlemoduletemplate.domain.usecases

import dima.inc.singlemoduletemplate.common.model.Result
import dima.inc.singlemoduletemplate.domain.models.MastodonInfo

interface UseCase {
    suspend operator fun invoke(): Result<List<MastodonInfo>>
}