package com.akshay.credstackview.home.transaction

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.credstackview.activity.ActivityScope
import com.akshay.credstackview.databinding.TransactionDetailBinding
import com.akshay.credstackview.databinding.TransactionItemBinding
import com.akshay.credstackview.recyclerview.BindableAdapter
import com.akshay.credstackview.viewmodel.ViewModelProvider
import com.akshay.domain.user.UserController
import javax.inject.Inject

@ActivityScope
class TransactionPresenter @Inject constructor(
  private val activity: AppCompatActivity,
  private val userController: UserController,
  private val viewModelProvider: ViewModelProvider<TransactionViewModel>
) {

  private val transactionDetailViewModel by lazy {
    getTransactionViewModel()
  }

  fun handleCredPlans(binding: TransactionDetailBinding) {
    binding.transactionDetailRecyclerView.apply {
      layoutManager =
        LinearLayoutManager(activity.applicationContext, LinearLayoutManager.HORIZONTAL, false)
      adapter = createRecyclerViewAdapter()
    }

    binding.apply {
      viewModel = transactionDetailViewModel
    }

    val listOfTransactionDetails = userController.getUser().userTransactionDetails
    transactionDetailViewModel.setTransactionDetailList(listOfTransactionDetails)
  }

  private fun createRecyclerViewAdapter(): BindableAdapter<TransactionItemViewModel> {
    return BindableAdapter.AdapterBuilder
      .newBuilder<TransactionItemViewModel>()
      .registerView(
        inflateDataBinding = TransactionItemBinding::inflate,
        setViewModel = TransactionItemBinding::setViewModel
      ).build()
  }

  private fun getTransactionViewModel(): TransactionViewModel {
    return viewModelProvider.getForActivity(activity, TransactionViewModel::class.java)
  }
}