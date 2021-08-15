package com.akshay.credstackview.home

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.akshay.credstackview.R
import com.akshay.credstackview.activity.ActivityScope
import com.akshay.credstackview.databinding.ActivityHomeBinding
import com.akshay.credstackview.home.creditamount.CreditAmountPresenter
import com.akshay.credstackview.home.plans.PlansPresenter
import com.akshay.credstackview.viewmodel.ViewModelProvider
import javax.inject.Inject

@ActivityScope
class HomePresenter @Inject constructor(
  private val activity: AppCompatActivity,
  private val creditAmountPresenter: CreditAmountPresenter,
  private val plansPresenter: PlansPresenter,
  private val viewModelProvider: ViewModelProvider<HomeViewModel>
) {

  private lateinit var binding: ActivityHomeBinding

  private val homeScreenViewModel by lazy {
    getHomeViewModel()
  }

  fun handleOnCreate() {
    binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
      activity,
      R.layout.activity_home
    )
    binding.apply {
      lifecycleOwner = activity
      viewModel = homeScreenViewModel
    }
    creditAmountPresenter.handleCreditAmount(binding.creditAmount)
    plansPresenter.handleCredPlans(binding.creditAmount.plansView)
  }

  private fun getHomeViewModel(): HomeViewModel {
    return viewModelProvider.getForActivity(activity, HomeViewModel::class.java)
  }

}
