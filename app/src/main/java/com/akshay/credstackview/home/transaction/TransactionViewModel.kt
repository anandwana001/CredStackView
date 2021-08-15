package com.akshay.credstackview.home.transaction

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.akshay.credstackview.activity.ActivityScope
import com.akshay.data.model.TransactionDetail
import javax.inject.Inject

@ActivityScope
class TransactionViewModel @Inject constructor(
  activity: AppCompatActivity
) : ViewModel() {

  private lateinit var transactionDetailList: List<TransactionDetail>

  fun setTransactionDetailList(transactionDetailList: List<TransactionDetail>) {
    this.transactionDetailList = transactionDetailList
  }

  private val arrayList = ArrayList<TransactionItemViewModel>()

  val transactionItemViewModelList: List<TransactionItemViewModel> by lazy {
    getRecyclerViewItemList()
  }

  private fun getRecyclerViewItemList(): ArrayList<TransactionItemViewModel> {
    for (item in transactionDetailList) {
      val transactionItemViewModel = TransactionItemViewModel(
        item.phoneNumber,
        item.paymentType.fullTypeName
      )
      arrayList.add(transactionItemViewModel)
    }
    return arrayList
  }
}