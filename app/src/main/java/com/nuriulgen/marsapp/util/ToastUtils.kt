package com.nuriulgen.marsapp.util

import android.content.Context
import android.widget.Toast
import com.nuriulgen.marsapp.presentation.home.view.HomeActivity


object ToastUtils {
    fun showError(message: String?, context: Context?) {
        ToastUtils.getToast(message!!, context!!).show()
    }

    fun showShortMessage(message: String?, context: Context?) {
        ToastUtils.getToast(message!!, context!!, Toast.LENGTH_SHORT).show()
    }

    private fun getToast(message: String, context: Context): Toast {
        return ToastUtils.getToast(message, context, Toast.LENGTH_LONG)
    }

    private fun getToast(message: String, context: Context, length: Int): Toast {
        return Toast.makeText(context, message, length)
    }
}