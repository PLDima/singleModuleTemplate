package dima.inc.singlemoduletemplate.domain.repo

import dima.inc.singlemoduletemplate.data.api.Api
import javax.inject.Inject

class MastodonRepositoryImpl @Inject constructor(
    private val api: Api
) : MastodonRepository {

    override fun getInstances() {
        api.getRandomSamples()
    }
}