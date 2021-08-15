package com.akshay.data.model

/** Structure of single User. */
data class User(
  val creditLimit: Int,
  val name: String,
  val phoneNumber: Long,
  val paymentType: PaymentTypes,
)
