package com.akshay.credstackview.home.creditamount

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akshay.credstackview.activity.ActivityScope
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

@ActivityScope
class CreditAmountViewModel @Inject constructor() : ViewModel() {

  val userName = MutableLiveData<String>()
  val userCreditLimit = MutableLiveData<String>()
  val endTransition = ObservableField<Boolean>(false)

  fun formatCurrency(creditLimit: Int) {
    val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    userCreditLimit.value = formatter.format(creditLimit)
  }

  fun onClick() {
    if (endTransition.get() != false) {
      endTransition.set(false)
    } else {
      endTransition.set(true)
    }
  }
}
