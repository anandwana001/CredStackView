package com.akshay.domain.interestrate

import com.akshay.data.model.InterestRate
import javax.inject.Singleton

/** Controller for retrieving, adding, updating, and deleting interest rate. */
@Singleton
class InterestRateController {

  fun createInterestRate(): InterestRate {
    return InterestRate(
      monthlyInterestRate = 1.04
    )
  }
}
