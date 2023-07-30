package dima.inc.singlemoduletemplate.domain.repo

import android.util.Log
import dima.inc.singlemoduletemplate.data.api.Api
import javax.inject.Inject

class MastodonRepositoryImpl @Inject constructor(
    private val api: Api,
) : MastodonRepository {

    override suspend fun getInstances() {
        Log.e("logs", api.getRandomSamples(1).toString())
    }
}