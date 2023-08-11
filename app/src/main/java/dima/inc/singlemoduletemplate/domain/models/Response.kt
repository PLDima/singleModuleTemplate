package dima.inc.singlemoduletemplate.domain.models

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("instances")
    val resultList: List<Instance>,
)
