package dima.inc.singlemoduletemplate.domain.models

data class MastodonInfo(
    val id: String,
    val name: String,
    val lastUpdateTime: String,
    val isDead: Boolean,
    val users: Int,
    val isRegistrationOpen: Boolean,
    val info: MastadonDescription,
    val imageUrl: String,
    val activeUsers: Int,
    val email: String,
    val adminName: String,
)
