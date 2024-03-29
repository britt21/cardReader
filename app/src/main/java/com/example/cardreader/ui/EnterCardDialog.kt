package com.example.cardreader.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cardreader.databinding.EnterCardDialogBinding
import com.example.cardreader.utils.helper.NetworkHelper
import com.example.cardreader.utils.helper.hideDialog
import com.example.cardreader.utils.helper.hideLoading
import com.example.cardreader.utils.helper.showLoading
import com.example.cardreader.utils.helper.showMessageDialog

class EnterCardDialog :DialogFragment() {
    lateinit var binding : EnterCardDialogBinding
    lateinit var cardViewModel: CardViewModel

    lateinit var dimbg: ConstraintLayout
    lateinit var dialogbg: ConstraintLayout
    lateinit var dialogText: TextView
    lateinit var dialogbtn: Button



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = EnterCardDialogBinding.inflate(inflater)

        cardViewModel= ViewModelProvider(this).get(CardViewModel::class.java)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        dimbg = binding.dimbg
        dialogbg = binding.dlogbg
        dialogText = binding.dialogText
        dialogbtn = binding.dialogbtn

        binding.etclose.setOnClickListener {
            dialog?.dismiss()
        }

        dialog?.setCancelable(false)


        var pinView = binding.tvPinblockVale
        pinView.doOnTextChanged { text, start, before, count ->
            when (text?.length) {
                6 -> {
                    binding.retrybtn.setOnClickListener {
                        hideDialog(dimbg, dialogbg,null)
                        validateCustomerInfo(text.toString())


                    }
                     validateCustomerInfo(text.toString())
                    println("dtextigot  : ${text.toString()}")
                    }
                }
            }


        pinView.setPasswordHidden(true);
        pinView.setHideLineWhenFilled(true);

        return  binding.root

    }

    private fun validateCustomerInfo(info: String) {
        if (info.isNotEmpty()) {
            cardViewModel.getCustomerInfo(info)
            observeCustomerInfo()

            val imm =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.tvPinblockVale.windowToken, 0)
        }
        }

    private fun observeCustomerInfo() {
        cardViewModel.liveCustomerInfo.observe(this, Observer { info ->

            when (info) {
                is NetworkHelper.Loading -> {
                    showLoading(dimbg, null)
                }

                is NetworkHelper.Success -> {
                    hideLoading(dimbg,null)
                    hideDialog(dimbg, dialogbg,null)
                    cardViewModel.liveCustomerInfo.removeObservers(this)
                    var intent = Intent(requireContext(),CardDetailsHome::class.java)
                    intent.putExtra("cardInfo",info.data)
                    startActivity(intent)
                }

                is NetworkHelper.Message -> {
                    cardViewModel.liveCustomerInfo.removeObservers(this)
                    hideLoading(dimbg, null)
                    info.message?.let { showMessageDialog(dimbg,dialogbg, it,dialogText,dialogbtn) }




                }
            }


        })    }

}