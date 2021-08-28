package com.akshay.credstackview.home.creditamount

import androidx.appcompat.app.AppCompatActivity
import com.akshay.credstackview.activity.ActivityScope
import com.akshay.credstackview.databinding.AmountViewBinding
import com.akshay.credstackview.viewmodel.ViewModelProvider
import com.akshay.domain.user.UserController
import javax.inject.Inject

@ActivityScope
class CreditAmountPresenter @Inject constructor(
  private val activity: AppCompatActivity,
  private val userController: UserController,
  private val viewModelProvider: ViewModelProvider<CreditAmountViewModel>
) {

  private val creditViewModel by lazy {
    getCreditAmountViewModel()
  }

  fun handleCreditAmount(binding: AmountViewBinding) {
    binding.apply {
      viewModel = creditViewModel
    }
    val user = userController.getUser()
    creditViewModel.userName.value = user.name
    creditViewModel.formatCurrency(user.creditLimit)
  }

  private fun getCreditAmountViewModel(): CreditAmountViewModel {
    return viewModelProvider.getForActivity(activity, CreditAmountViewModel::class.java)
  }
}
