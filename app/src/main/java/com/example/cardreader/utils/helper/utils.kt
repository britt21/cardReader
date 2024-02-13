package com.example.cardreader.utils.helper

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout

fun showLoading(dimbg : ConstraintLayout, anybutton: Button? = null){
    dimbg.visibility = View.VISIBLE
    anybutton?.isEnabled = false
}


fun hideLoading(dimbg : ConstraintLayout, anybutton: Button? = null){
    dimbg.visibility = View.GONE
    anybutton?.isEnabled = true
}