package com.example.cardreader.utils.helper

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


fun showLoading(dimbg : ConstraintLayout, anybutton: Button? = null){
    dimbg.visibility = View.VISIBLE
    anybutton?.isEnabled = false
}


fun hideLoading(dimbg : ConstraintLayout, anybutton: Button? = null){
    dimbg.visibility = View.GONE
    anybutton?.isEnabled = true
}

fun hideDialog(dimbg : ConstraintLayout, dialogbg : ConstraintLayout, anybutton: Button?){
    dimbg.visibility = View.GONE
    dialogbg.visibility = View.GONE
    anybutton?.isEnabled= true
}


fun showMessageDialog(dimbg : ConstraintLayout, dialogbg : ConstraintLayout, dialogtext : String, dialogTextview : TextView, dialogbtn: Button? = null){

    dimbg.visibility = View.VISIBLE
    dialogbg.visibility = View.VISIBLE
    dialogTextview.text = dialogtext
    dialogbtn?.setOnClickListener {
        hideDialog(dimbg,dialogbg,anybutton = null)
    }
}