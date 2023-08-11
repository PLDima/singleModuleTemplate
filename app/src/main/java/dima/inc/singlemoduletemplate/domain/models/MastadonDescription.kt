package dima.inc.singlemoduletemplate.domain.models

import com.google.gson.annotations.SerializedName


data class MastadonDescription(
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("full_description")
    val fullDescription: String?,
    @SerializedName("topic")
    val topic: String,
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("other_languages_accepted")
    val isOtherLanguagesAccepted: Boolean,
    @SerializedName("federates_with")
    val federatesWith: String,
    @SerializedName("prohibited_content")
    val prohibitedContent: List<String>,
    @SerializedName("categories")
    val categories: List<String>,
)
