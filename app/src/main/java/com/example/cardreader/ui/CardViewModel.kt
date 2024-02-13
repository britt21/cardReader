package com.example.cardreader.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardreader.data.card_info.response.CardInfoResponse
import com.example.cardreader.data.card_info.response.new_card_response.NewCardResponse
import com.example.cardreader.domain.cardService
import com.example.cardreader.utils.helper.BaseClient
import com.example.cardreader.utils.helper.NetworkHelper
import kotlinx.coroutines.launch

class CardViewModel : ViewModel() {

    var baseClient = BaseClient()


    var liveCustomerInfo: MutableLiveData<NetworkHelper<NewCardResponse>> = MutableLiveData()

    fun getCustomerInfo(cardNumber: String) {
        liveCustomerInfo.value = NetworkHelper.Loading()
        viewModelScope.launch {
            try {
                var result = cardService.cardServiceInstance.getCardInfo(cardNumber)
                liveCustomerInfo.value = baseClient.handleResponse(result)

            }catch (e : Exception){
                liveCustomerInfo.value = NetworkHelper.Message(e.localizedMessage)

            }
        }
    }


}