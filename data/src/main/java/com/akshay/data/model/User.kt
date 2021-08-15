package com.akshay.data.model

data class User(
  val creditLimit: Int,
  val name: String,
  val phoneNumber: Long,
  val paymentType: PaymentTypes,
)
