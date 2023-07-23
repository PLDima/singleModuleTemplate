package dima.inc.singlemoduletemplate.data.repo

import dima.inc.singlemoduletemplate.data.api.Api
import dima.inc.singlemoduletemplate.domain.repo.MastodonRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: Api
) :  MastodonRepository {

    override fun getInstances() {
        api.getRandomSamples()
    }
}