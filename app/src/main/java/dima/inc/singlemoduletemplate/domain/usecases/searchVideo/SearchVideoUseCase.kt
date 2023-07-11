package dima.inc.singlemoduletemplate.domain.usecases.searchVideo

import dima.inc.singlemoduletemplate.data.models.Video

interface SearchVideoUseCase{

    suspend operator fun invoke(request: String): List<Video>
}