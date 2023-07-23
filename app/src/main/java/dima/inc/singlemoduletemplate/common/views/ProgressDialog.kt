package dima.inc.singlemoduletemplate.common.views

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import dima.inc.singlemoduletemplate.R

class ProgressDialog(context: Context) {

    private val progressDialog: AlertDialog by lazy {
        AlertDialog.Builder(context)
            .setView(R.layout.dialog_loading)
            .setCancelable(false)
            .create()
            .apply { window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) }
    }

    fun show() {
        progressDialog.show()
    }

    fun hide() {
        progressDialog.dismiss()
    }
}