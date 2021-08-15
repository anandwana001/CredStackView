package com.akshay.credstackview.home

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akshay.credstackview.activity.ActivityScope
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

@ActivityScope
class HomeViewModel @Inject constructor(
  activity: AppCompatActivity
) : ViewModel() {

  val userName = MutableLiveData<String>()
  val userCreditLimit = MutableLiveData<String>()

  fun formatCurrency(creditLimit: Int) {
    val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    userCreditLimit.value = formatter.format(creditLimit)
  }
}
