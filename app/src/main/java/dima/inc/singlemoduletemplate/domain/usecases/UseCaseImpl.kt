package dima.inc.singlemoduletemplate.domain.usecases

import dima.inc.singlemoduletemplate.common.model.Result
import dima.inc.singlemoduletemplate.domain.models.MastodonInfo
import dima.inc.singlemoduletemplate.domain.repo.MastodonRepository
import javax.inject.Inject

class UseCaseImpl @Inject constructor(
    private val mastodonRepository: MastodonRepository,
) : UseCase {

    override suspend fun invoke(): Result<List<MastodonInfo>> = mastodonRepository.getInstances()

}