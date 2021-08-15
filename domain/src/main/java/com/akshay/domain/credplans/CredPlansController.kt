package com.akshay.domain.credplans

import com.akshay.data.model.CredPlan
import javax.inject.Inject
import javax.inject.Singleton

/** Controller for retrieving, adding, updating, and deleting cred plans. */
@Singleton
class CredPlansController @Inject constructor() {

  private var listOfCredPlan: List<CredPlan>

  init {
    listOfCredPlan = createCredPlans()
  }

  private fun createCredPlans(): List<CredPlan> {
    return listOf<CredPlan>(
      CredPlan(
        pricePerMonth = 4247,
        timePeriodInMonths = 12,
        isRecommended = false
      ),
      CredPlan(
        pricePerMonth = 5580,
        timePeriodInMonths = 9,
        isRecommended = true
      ),
      CredPlan(
        pricePerMonth = 8240,
        timePeriodInMonths = 6,
        isRecommended = false
      ),
      CredPlan(
        pricePerMonth = 10223,
        timePeriodInMonths = 4,
        isRecommended = false
      )
    )
  }

  fun getListOfCredPlan() = listOfCredPlan
}
