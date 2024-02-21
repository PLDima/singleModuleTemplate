package dima.inc.singlemoduletemplate.data.mappers

import dima.inc.singlemoduletemplate.domain.models.MastodonInfo
import dima.inc.singlemoduletemplate.domain.models.ResponseResult
import javax.inject.Inject

class InstanceToMastodonInfoMapper @Inject constructor() :
        (ResponseResult) -> List<MastodonInfo> {

    override fun invoke(responseResult: ResponseResult): List<MastodonInfo> {
        val responseResultList: MutableList<MastodonInfo> = mutableListOf()
        responseResult.resultList.forEach { instance ->
            responseResultList.add(
                MastodonInfo(
                    id = instance.id,
                    name = instance.name,
                    lastUpdateTime = instance.lastUpdateTime,
                    isDead = instance.isDead,
                    users = instance.users,
                    isRegistrationOpen = instance.isRegistrationOpen,
                    info = instance.info,
                    imageUrl = instance.imageUrl,
                    activeUsers = instance.activeUsers,
                    email = instance.email,
                    adminName = instance.adminName
                )
            )
        }
        return responseResultList
    }
}