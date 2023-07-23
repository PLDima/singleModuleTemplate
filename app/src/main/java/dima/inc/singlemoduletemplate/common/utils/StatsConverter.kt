package dima.inc.singlemoduletemplate.common.utils

import android.content.Context
import com.app.youtubeedu.util.StringProvider
import com.app.youtubeedu.util.StringProviderImpl
import dima.inc.singlemoduletemplate.R

object StatsConverter {

    fun convertStatsToString(amount: Long, context: Context): String {
        val stringProvider: StringProvider = StringProviderImpl(context)
        return when {
            amount > 1_000_000_000 -> stringProvider.provideString(R.string.billion, amount / 1_000_000_000)
            amount > 1_000_000 -> stringProvider.provideString(R.string.million, amount / 1_000_000)
            amount > 1_000 -> stringProvider.provideString(R.string.thousand, amount / 1_000)
            else -> amount.toString()
        }
    }
}