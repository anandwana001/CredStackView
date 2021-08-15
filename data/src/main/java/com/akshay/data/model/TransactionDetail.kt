package com.akshay.data.model

data class TransactionDetail(
  val phoneNumber: Long,
  val paymentType: PaymentTypes,
  val bankAccountNumber: Int,
  val bankName: String?
) {
  constructor(phoneNumber: Long, paymentType: PaymentTypes) : this(phoneNumber, paymentType, 0, "")
}

