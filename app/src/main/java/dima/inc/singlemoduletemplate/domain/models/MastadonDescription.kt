package dima.inc.singlemoduletemplate.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MastadonDescription(
    @Json(name = "short_description")
    val shortDescription: String?,
    @Json(name = "full_description")
    val fullDescription: String?,
    @Json(name = "topic")
    val topic: String,
    @Json(name = "languages")
    val languages: List<String>,
    @Json(name = "other_languages_accepted")
    val isOtherLanguagesAccepted: Boolean,
    @Json(name = "federates_with")
    val federatesWith: String,
    @Json(name = "prohibited_content")
    val prohibitedContent: List<String>,
    @Json(name = "categories")
    val categories: List<String>,
)
