package com.akshay.credstackview.home

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.akshay.credstackview.R
import com.akshay.credstackview.activity.ActivityScope
import com.akshay.credstackview.databinding.ActivityHomeBinding
import com.akshay.credstackview.viewmodel.ViewModelProvider
import com.akshay.domain.user.UserController
import javax.inject.Inject

@ActivityScope
class HomePresenter @Inject constructor(
  private val activity: AppCompatActivity,
  private val userController: UserController,
  private val viewModelProvider: ViewModelProvider<HomeViewModel>
) {

  private val homeScreenViewModel by lazy {
    getHomeViewModel()
  }

  fun handleOnCreate() {
    val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
      activity,
      R.layout.activity_home
    )
    binding.apply {
      lifecycleOwner = activity
      viewModel = homeScreenViewModel
    }
    subscribeToData()
  }

  private fun subscribeToData() {
    val user = userController.getUser()
    homeScreenViewModel.userName.value = user.name
    homeScreenViewModel.formatCurrency(user.creditLimit)
  }

  private fun getHomeViewModel(): HomeViewModel {
    return viewModelProvider.getForActivity(activity, HomeViewModel::class.java)
  }

}
