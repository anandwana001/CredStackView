package com.akshay.credstackview.home.plans

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.credstackview.activity.ActivityScope
import com.akshay.credstackview.databinding.PlansViewBinding
import com.akshay.credstackview.viewmodel.ViewModelProvider
import com.akshay.domain.credplans.CredPlansController
import javax.inject.Inject

@ActivityScope
class PlansPresenter @Inject constructor(
  private val activity: AppCompatActivity,
  private val plansController: CredPlansController,
  private val viewModelProvider: ViewModelProvider<PlansViewModel>
) {

  @Inject
  lateinit var plansAdapter: PlansAdapter

  private val credPlansViewModel by lazy {
    getPlansViewModel()
  }

  fun handleCredPlans(binding: PlansViewBinding) {
    binding.apply {
      viewModel = credPlansViewModel
    }

    val horizontalLayoutManager =
      LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
    binding.plansRecyclerView.apply {
      adapter = plansAdapter
      layoutManager = horizontalLayoutManager
    }

    val listOfPlans = plansController.getListOfCredPlan()
    plansAdapter.setPlansList(listOfPlans)
  }

  private fun getPlansViewModel(): PlansViewModel {
    return viewModelProvider.getForActivity(activity, PlansViewModel::class.java)
  }
}