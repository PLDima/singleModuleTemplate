package dima.inc.singlemoduletemplate.domain.usecases.getRelatedVideo

import dima.inc.singlemoduletemplate.data.models.Video

interface GetRelatedVideoUseCase{

    suspend operator fun invoke(video: Video): List<Video>
}