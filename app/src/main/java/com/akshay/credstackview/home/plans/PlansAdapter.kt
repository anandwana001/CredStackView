package com.akshay.credstackview.home.plans

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akshay.credstackview.R
import com.akshay.credstackview.databinding.PlansItemBinding
import com.akshay.data.model.CredPlan
import javax.inject.Inject

class PlansAdapter @Inject constructor() : RecyclerView.Adapter<PlansAdapter.PlansViewHolder>() {

  private lateinit var listOfPlans: List<CredPlan>

  fun setPlansList(listOfPlans: List<CredPlan>) {
    this.listOfPlans = listOfPlans
  }

  inner class PlansViewHolder(val binding: PlansItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(plan: CredPlan) {
      if (plan.isRecommended) {
        binding.planRecommended.visibility = View.VISIBLE
      }
      // TODO (): Formatting required
      binding.planPeriod.text = plan.timePeriodInMonths.toString()

      // TODO (): Formatting required
      binding.planPrice.text = plan.pricePerMonth.toString()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlansViewHolder {
    val plansItemBinding =
      PlansItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return PlansViewHolder(plansItemBinding)
  }

  override fun onBindViewHolder(holder: PlansViewHolder, position: Int) {
    holder.bind(listOfPlans[position])
  }

  override fun getItemCount(): Int = listOfPlans.size
}