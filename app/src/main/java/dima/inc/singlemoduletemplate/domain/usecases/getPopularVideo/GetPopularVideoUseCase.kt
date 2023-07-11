package dima.inc.singlemoduletemplate.domain.usecases.getPopularVideo

import dima.inc.singlemoduletemplate.data.models.Video

interface GetPopularVideoUseCase{

    suspend operator fun invoke(): List<Video>
}