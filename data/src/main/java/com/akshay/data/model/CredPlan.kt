package com.akshay.data.model

/** Structure of single credit plan offered. */
data class CredPlan(
  val pricePerMonth: Int,
  val timePeriodInMonths: Int,
  val isRecommended: Boolean
)
