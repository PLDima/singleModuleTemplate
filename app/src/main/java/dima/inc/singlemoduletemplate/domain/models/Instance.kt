package dima.inc.singlemoduletemplate.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Instance(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "added_at")
    val foundedDate: String,
    @Json(name = "updated_at")
    val lastUpdateTime: String,
    @Json(name = "checked_at")
    val lastCheckDate: String,
    @Json(name = "uptime")
    val uptime: Int,
    @Json(name = "up")
    val up: Boolean,
    @Json(name = "dead")
    val isDead: Boolean,
    @Json(name = "version")
    val version: String,
    @Json(name = "ipv6")
    val ipv6: Boolean,
    @Json(name = "https_scope")
    val httpsScope: Int,
    @Json(name = "https_rank")
    val httpsRank: String,
    @Json(name = "obs_score")
    val ObsScore: String,
    @Json(name = "users")
    val users: Int,
    @Json(name = "statuses")
    val statuses: Int,
    @Json(name = "connections")
    val connections: Int,
    @Json(name = "open_registrations")
    val isRegistrationOpen: Boolean,
    @Json(name = "info")
    val info: MastadonDescription,
    @Json(name = "thumbnail")
    val imageUrl: String,
    @Json(name = "thumbnail_proxy")
    val imageUrlProxy: String,
    @Json(name = "active_users")
    val activeUsers: Int,
    @Json(name = "email")
    val email: String,
    @Json(name = "admin")
    val adminName: String,
)
