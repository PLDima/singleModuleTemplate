package dima.inc.singlemoduletemplate.domain.repo

import dima.inc.singlemoduletemplate.common.utils.safeApiCallWithResult
import dima.inc.singlemoduletemplate.data.api.Api
import dima.inc.singlemoduletemplate.data.mappers.InstanceToMastodonInfoMapper
import dima.inc.singlemoduletemplate.domain.models.MastodonInfo
import dima.inc.singlemoduletemplate.common.model.Result
import javax.inject.Inject

class MastodonRepositoryImpl @Inject constructor(
    private val instanceToMastodonInfoMapper: InstanceToMastodonInfoMapper,
    private val api: Api,
) : MastodonRepository {

    override suspend fun getInstances(): Result<List<MastodonInfo>> {
         return safeApiCallWithResult(instanceToMastodonInfoMapper, call = {
             api.getRandomSamples(1)
         })
    }
}