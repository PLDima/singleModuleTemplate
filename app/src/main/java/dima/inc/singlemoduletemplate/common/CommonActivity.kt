package dima.inc.singlemoduletemplate.common

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class CommonActivity(
    @LayoutRes private val contentId: Int
) : AppCompatActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(contentId)
        onContentCreated()
        if (savedInstanceState != null) {
            restoreUIState(savedInstanceState)
        }
    }

    fun onContentCreated() {}

    open fun restoreUIState(savedInstanceState: Bundle) {}
}