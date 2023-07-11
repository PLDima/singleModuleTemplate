package dima.inc.singlemoduletemplate.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class Video(
    val name: String,
    val description: String,
    val videoId: String,
    val iconUri: String,
    val views: Long,
    val likes: Long,
    val dislikes: Long,
): Parcelable