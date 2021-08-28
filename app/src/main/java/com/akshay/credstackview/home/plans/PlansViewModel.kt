package com.akshay.credstackview.home.plans

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.akshay.credstackview.activity.ActivityScope
import com.akshay.data.model.CredPlan
import javax.inject.Inject

@ActivityScope
class PlansViewModel @Inject constructor() : ViewModel() {

  private lateinit var credPlansList: List<CredPlan>
  val endTransition = ObservableField<Boolean>(false)

  fun setPlansList(credPlansList: List<CredPlan>) {
    this.credPlansList = credPlansList
  }

  private val arrayList = ArrayList<PlanItemViewModel>()

  val credPlanItemModelList: List<PlanItemViewModel> by lazy {
    getRecyclerViewItemList()
  }

  private fun getRecyclerViewItemList(): ArrayList<PlanItemViewModel> {
    for (item in credPlansList) {
      val planItemViewModel = PlanItemViewModel(item)
      arrayList.add(planItemViewModel)
    }
    return arrayList
  }

  fun onClick() {
    if (endTransition.get() != false) {
      endTransition.set(false)
    } else {
      endTransition.set(true)
    }
  }
}
