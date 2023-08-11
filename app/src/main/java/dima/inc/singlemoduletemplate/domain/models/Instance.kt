package dima.inc.singlemoduletemplate.domain.models

import com.google.gson.annotations.SerializedName


data class Instance(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("added_at")
    val foundedDate: String,
    @SerializedName("updated_at")
    val lastUpdateTime: String,
    @SerializedName("checked_at")
    val lastCheckDate: String,
    @SerializedName("uptime")
    val uptime: Int,
    @SerializedName("up")
    val up: Boolean,
    @SerializedName("dead")
    val isDead: Boolean,
    @SerializedName("version")
    val version: String,
    @SerializedName("ipv6")
    val ipv6: Boolean,
    @SerializedName("https_scope")
    val httpsScope: Int,
    @SerializedName("https_rank")
    val httpsRank: String,
    @SerializedName("obs_score")
    val ObsScore: String,
    @SerializedName("users")
    val users: Int,
    @SerializedName("statuses")
    val statuses: Int,
    @SerializedName("connections")
    val connections: Int,
    @SerializedName("open_registrations")
    val isRegistrationOpen: Boolean,
    @SerializedName("info")
    val info: MastadonDescription,
    @SerializedName("thumbnail")
    val imageUrl: String,
    @SerializedName("thumbnail_proxy")
    val imageUrlProxy: String,
    @SerializedName("active_users")
    val activeUsers: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("admin")
    val adminName: String,
)
