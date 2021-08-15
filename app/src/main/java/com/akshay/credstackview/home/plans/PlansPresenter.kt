package com.akshay.credstackview.home.plans

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.credstackview.activity.ActivityScope
import com.akshay.credstackview.databinding.PlansItemBinding
import com.akshay.credstackview.databinding.PlansViewBinding
import com.akshay.credstackview.recyclerview.BindableAdapter
import com.akshay.credstackview.viewmodel.ViewModelProvider
import com.akshay.domain.credplans.CredPlansController
import javax.inject.Inject

@ActivityScope
class PlansPresenter @Inject constructor(
  private val activity: AppCompatActivity,
  private val plansController: CredPlansController,
  private val viewModelProvider: ViewModelProvider<PlansViewModel>
) {

  private val credPlansViewModel by lazy {
    getPlansViewModel()
  }

  fun handleCredPlans(binding: PlansViewBinding) {
    binding.plansRecyclerView.apply {
      layoutManager =
        LinearLayoutManager(activity.applicationContext, LinearLayoutManager.HORIZONTAL, false)
      adapter = createRecyclerViewAdapter()
    }

    binding.apply {
      viewModel = credPlansViewModel
    }

    val listOfPlans = plansController.getListOfCredPlan()
    credPlansViewModel.setPlansList(listOfPlans)
  }

  private fun createRecyclerViewAdapter(): BindableAdapter<PlanItemViewModel> {
    return BindableAdapter.AdapterBuilder
      .newBuilder<PlanItemViewModel>()
      .registerView(
        inflateDataBinding = PlansItemBinding::inflate,
        setViewModel = PlansItemBinding::setViewModel
      ).build()
  }

  private fun getPlansViewModel(): PlansViewModel {
    return viewModelProvider.getForActivity(activity, PlansViewModel::class.java)
  }
}