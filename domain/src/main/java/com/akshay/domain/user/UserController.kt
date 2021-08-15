package com.akshay.domain.user

import com.akshay.data.model.PaymentTypes
import com.akshay.data.model.TransactionDetail
import com.akshay.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

/** Controller for retrieving, adding, updating, and deleting users. */
@Singleton
class UserController @Inject constructor() {

  private var user: User

  init {
    user = createUser()
  }

  private fun createUser(): User {
    val transactionDetailList = listOf<TransactionDetail>(
      TransactionDetail(
        phoneNumber = 919935670475,
        paymentType = PaymentTypes.PAYTM
      )
    )

    return User(
      name = "Nikunj",
      creditLimit = 487891,
      userTransactionDetails = transactionDetailList
    )
  }

  fun getUser() = user
}
