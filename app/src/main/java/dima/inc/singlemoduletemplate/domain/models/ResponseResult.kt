package dima.inc.singlemoduletemplate.domain.models

import com.google.gson.annotations.SerializedName

data class ResponseResult(
    @SerializedName("instances")
    val resultList: List<Instance>,
)
